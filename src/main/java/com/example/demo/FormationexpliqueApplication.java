package main.java.com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
  //Il s'agit d'une annotation de commodité qui ajoute tout ce qui va suivre.

public class FormationexpliqueApplication {
  //Classe principale créée automatiquement lors de la création du projet. 
  //On doit uniquement lui donner un nom.                      
  
	public static void main(String[] args) {
	
		//La main est la méthode qui se trouve dans la classe principale dans 
		//la racine de la pile d'exécution. Dans Java, chaque application ou programme
		//doit contenir la méthode main.
		//Avant d'être utilisée, une méthode doit être définie car pour l'appeler dans une 
		// classe il faut que le compilateur la connaisse, c'est-à-dire qu'il connaisse son nom, 
		//ses arguments et les instructions qu'elle contient. 
		//Les arguments sont facultatifs, mais s'il n'y a pas d'arguments, les parenthèses doivent 
		//rester présentes
		//La définition d'une méthode s'appelle "déclaration". 
		//La déclaration d'une fonction se fait selon la syntaxe suivante : 
		//TypeDeRetour nomDeLaMethode(Type1 argument1, Type2 argument2) {
		//liste d'instructions
	    //}
		//public static void main (string [ ] args)
		  //public : main est accessible à partir d'autres classes;
		  //static : invoque la méthode sans instancier l'objet de la classe;
		  //void : la procédure n'a pas de retour.
		  //La méthode main accepte un seul argument sous forme d'un tableau de 
		  //chaîne de caractères String 
		  //Arg : II est possible de passer des arguments (appelés aussi paramètres) 
		  //à une méthode, cad lui fournir une 	valeur ou le nom d'une variable 
		  //afin que la méthode puisse effectuer des opérations sur ces arguments 
		  //ou bien grâce à ces arguments. Le passage d'arguments à une méthode 
		  //se fait au moyen d'une liste d'arguments (séparés par des vigules) 
		  //entre parenthèses suivant immédiatement le nom de la méthode.
		  //String [ ]
		  //Ce tableau est le mécanisme pour que le système passe les informations 
		  //à l'application. Chaque String est une ligne de commande. Par exemple : 
		  //java main arg1 arg2 arg3	
		
		SpringApplication.run(FormationexpliqueApplication.class, args);
	}
		// Dans la méthode main, on apppelle une autre méthode.
	    	  
	    //Pour démarrer l’application, utiliser SpringApplication.run
	    //Dans la plupart des cas, la run(Class, String[])méthode statique peut être
	    //appelée directement à partir de la méthode principale pour démarrer 
	    //l'application.
	    //.run : pour indiquer que le premier qui va démarrer l'application, c'est Spring.
	     //1/ Il va lire le fichier configuration
	     //2/ Il va scanner les classe, cad : quand il trouve une classe avec 
	         //l'annotation @Entity, il sait ce qu'il doit faire.
	     //3/ Il va définir Tomcat embarqué commserveur d'application.
	
}



