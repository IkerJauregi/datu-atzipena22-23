package dambi.accessingrelationaldata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.*;
@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;
  
    @PostMapping(path = "/add")
    public String addNewUser(@RequestParam String name, @RequestParam String email) {
      User n = new User();
      n.setName(name);
      n.setEmail(email);
      userRepository.save(n);
      return "Saved";
    }
  
    @GetMapping(path = "/all")
    public Iterable<User> getAllUsers() {
      return userRepository.findAll();
    }
  
    @PutMapping(path = "/update/{userId}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody User user, @PathVariable int userId) {
      try {
        user.setId(userId);
        userRepository.save(user);
  
        return ResponseEntity.ok().build();
  
      } catch (Exception ex) {
        return ResponseEntity.notFound().build();
      }
    }
  
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteUserById(@PathVariable int userId) {
      try {
        userRepository.deleteById(userId);
        return ResponseEntity.ok().build();
      } catch (Exception ex) {
        System.out.println("Errorea " + userId + " userra ezabatzerakoan. ");
        return ResponseEntity.notFound().build();
      }
    }
  
  }
