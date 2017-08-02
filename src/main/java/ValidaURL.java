

import org.apache.commons.validator.UrlValidator;

public class ValidaURL {

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		UrlValidator validar = new UrlValidator();
		
		if (validar.isValid("http://localhost:8080/pois-app/buenos-aires-turismos/pois")) {
			System.out.println("VALIDA");
		}else {
			System.out.println("NO VALIDO");
		}

	}

}
