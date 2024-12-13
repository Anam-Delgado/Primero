package Pro_Integrador;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// INTEGRADOR: 
	       /*Etapa 1:
			● Clave Token número aleatorio de 6 dígitos.
			● El cliente debe ingresar Usuario, contraseña y Clave Token(todos obligatorios).
			● El campo Usuario no distingue minúsculas o mayúsculas.
			● El campo Contraseña es sensible a las minúsculas y mayúsculas.
			● 3 intentos de logueo (dirigirse a la sucursal del banco más cercana 
			  para poder desbloquear sus credenciales) 
			● Por cada intento fallido, preguntar al cliente si desea continuar
			  colocando las credenciales de manera correcta.
	        ● Si el cliente coloca las credenciales de forma
	          correcta, deberá informar que ha ingresado correctamente al Online Banking.
			*/
			Scanner teclado = new Scanner(System.in);

			String usuario, usuarioInput, contrasena, contrasenaInput;
			int tokmax, tokmin, token, tokenInput, intentos;
			boolean acceso, continuar;
			char respuesta;
			usuario = "ana";
			contrasena = "Java";
			tokmax = 100000;
			tokmin = 1;
			token = (int) (Math.random() * (tokmax + 1) - tokmin) + tokmax;
			intentos = 3;
			acceso = false;
			continuar = true;

			do {
				System.out.println(
						"Bienvenido a Online Banking, por favor, ingrese las credenciales solicidadas:" + "\n");
				System.out.println("Clave token generada automáticamente: " + token);
				System.out.println("Usuario: ");
				usuarioInput = teclado.next().toLowerCase();
				System.out.println("Contraseña: ");
				contrasenaInput = teclado.next();
				System.out.println("Clave token: ");
				tokenInput = teclado.nextInt();
				intentos--;
				if ((!usuario.equals(usuarioInput)) || (!contrasena.equals(contrasenaInput) || (token != tokenInput))) { // primer
					if (intentos <= 0) {
						System.out.println("Usuario bloqueado!... Dirígirse a la sucursal del banco más cercana"
								+ " para poder desbloquear sus credenciales");
						continuar = false;
					} else {
						System.out.println("Error de credenciales... ¿Desea intentarlo de nuevo? (s/n): ");
						respuesta = teclado.next().charAt(0);
						// teclado.nextLine();
						if (respuesta == 'n' || respuesta == 'N') {
							System.out.println("Gacias por utilizar Online Banking");
							continuar = false;
						}
					}
				} else {
					System.out.println("Bienvenido al sistema!\n");
					intentos = 3;
					acceso = true;
				}
			} while ((acceso == false) && (intentos > 0) && (continuar == true));
		
		
	teclado.close();	
	}

}
