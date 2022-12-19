package com.dambi.lehenrestapia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Random;

@SpringBootApplication
@RestController
public class LehenrestapiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LehenrestapiaApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		return "Gure lehen rest apia martxan dago.";
	}

	@GetMapping("/kaixo")
	public String hello(@RequestParam(value = "izena", defaultValue = "mundua") String izena) {
		return String.format("Kaixo %s!", izena);
	}

	@GetMapping("/zenbatu")
	public String zenbatu(@RequestParam(value = "norarte", defaultValue = "5") String norarte) {
		Random rand = new Random();
		String strEmaitza = "";
		//strEmaitza += "<body background=\"https://i.kym-cdn.com/photos/images/newsfeed/002/111/316/c57.gif\" style=\"-webkit-background-size: cover;-moz-background-size: cover;-o-background-size: cover;background-size: cover;\">";
		for (int i = 1; i <= Integer.parseInt(norarte); i++) {
			int r = rand.nextInt(255);
			int b = rand.nextInt(255);
			int g = rand.nextInt(255);
			int n = rand.nextInt(100);
			n++;
			if (n >= 1 && n <= 5) {
				strEmaitza += ("<label style=\"color:red; font-size: 40px;\"><a href=\"https://amogus.org/conspiracmogus.html\" style=\"text-decoration: none;\"> <img src=\"https://d2t1xqejof9utc.cloudfront.net/screenshots/pics/d0dc0cd3fcf603c28df5f7874baf63fc/large.png\" width=\"40px\" height=\"40px\"></a></label>");
			} else if (n == 6) {
				strEmaitza += ("<label style=\"color:red; font-size: 40px;\"><a href=\"https://amogus.org/conspiracmogus.html\" style=\"text-decoration: none;\"><img src=\"https://media.tenor.com/eUOiCZiskd8AAAAC/monkey-spinning-holding-hands.gif\" width=\"40px\" height=\"40px\"></a></label>");

			} else {
				strEmaitza += ("<label style=\"color:rgb(" + r + "," + g + "," + b
						+ "); font-size: 40px;\">ඞ</label>");
			}
		}
		return strEmaitza;
	}
}
