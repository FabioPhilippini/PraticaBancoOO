package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaFormatos {
	
	private static final Pattern padraoCPF = Pattern.compile("([0-9]{3}\\.?){3}\\-?[0-9]{2}");
	private static final Pattern padraoTel = Pattern.compile("^(\\(?[1-9]{2}\\)?\\s)?([1-9]{4,5}\\-[0-9]{4})$");
	private static final Pattern padraoEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" 
				                                               + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	public static boolean formatoCPF(String cpf) {
		Matcher match = padraoCPF.matcher(cpf);
		return match.matches();
	}

	public static boolean formatoTelefone(String telefone) {
		Matcher match = padraoTel.matcher(telefone);
		return match.matches();
	}

	public static boolean formatoEmail(String email) {
		Matcher match = padraoEmail.matcher(email);
		return match.matches();
	}

}
