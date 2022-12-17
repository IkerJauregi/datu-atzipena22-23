package dambi.lehen_restapia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LehenRestapiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LehenRestapiaApplication.class, args);
	}
	@GetMapping("/")
	public String index() {
		return "Gure lehen rest apia martxan dago";
	}
	// Hurrengokoa ipinita mezuan Kaixo Bart agertuko da eta ez bada ezer ere ez ipintzen defaultValue jarriko du.
	// http://localhost:8080/kaixo?izena=Bart
	@GetMapping("/kaixo")
	public String kaixo(@RequestParam(value = "izena", defaultValue = "mundua") String izena){
		return String.format("Kaixo " + izena);
	}
	@GetMapping("/zenbatu")
	public String zenbatu(@RequestParam(value = "norarte", defaultValue = "5") String norarte){
		String mezuaEmaitza = "";
		for (int i = 1; i <= Integer.parseInt(norarte); i++) {
			mezuaEmaitza = mezuaEmaitza + (i + "\n");
		}
		return mezuaEmaitza;
	}
}
