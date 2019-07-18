// Logique de la présente page (cette page présente le service web, donc il faudra
// définir à la fois les entrées (ce que va écrire et demander l'utilisateur)
// définir ce qu'il va rédupérer comme retour pour sa demande.

// On commencera par définir nos entrées :
   // On va commencer par définir un premier url relatif aux produits ("/products") grâce à @RestController("/products")
   // On définit un 2ème url relatif à l'Id d'un produit "/{id}" @GetMapping("/{id}")
   // de manière à avoir en entrée au final un url global. Ex : /products/1 (Id du produit 1).

// Ensuite, on définira notre retour :
   // Ce sera un objet récupéré grâce à la méthode définie dans Service : jibProductById(Long id)
   // En fait, on va liver en entrée l'id d'un produit à une méthode "retrieve..."
   // avec le type (get) grâce à l'annotation @getMpappng.
   // D'autres types existent pour mapper des opérations HTTP vers une API :  
        //@get (pour récupérer des données),  
        //@head (La méthode HEAD demande une réponse identique à une requête GET pour laquelle on aura omis le corps de la réponse (on a uniquement l'en-tête).)
        //@post (La méthode POST est utilisée pour envoyer une entité vers la ressource indiquée)  
        //@put (La méthode PUT remplace toutes les représentations actuelles de la ressource visée par le contenu de la requête) 
        //@patch (La méthode PATCH est utilisée pour appliquer des modifications partielles à une ressource) 
        //@delete (La méthode DELETE supprime la ressource indiquée)
   // Cette méthode va se connecter aux services 
   // et nous livrer en retour le produit.

package com.example.demo.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.example.demo.model.entity.Product;
import com.example.demo.service.ProductService;

@RestController()
// on ajoute l'annotation @RestController pour dire au compilateur que la classe
// suivante ProductController est un controller (cad : webservice).
// En même temps, on a désigné un premier url (après /) à ce contrôleur.

public class ProductController {
	// classe créée automatiquement au moment de la création de la classe ProductController.java
	
	@Autowired
	    // Rappelons encore une fois que @autowired est le fait de "dire" à Spring qu'une
	    // instance d'un objet dans un bean1 peut être recherchée dans une autre instance 
	    // d'un bean 2 (injection des dépendances).
		// C’est une annotation qui nous permet de faire l’injection de dépendances entre 
	    // les beans de l’application (Spring va tout faire), il suffit juste d’annoter un 
	    // constructeur ou une méthode avec cette dernière et le conteneur Spring va faire 
	    // la suite : creation du bean, le chercher et l’injecter automatiquement….
		// Autrement dit, sans l'annotation @Autowired, l'objet (en bleu) ne sera pas instancé.
	
	private ProductService productService;
	// Bien entendu, le Controller ne peut pas aller directement à la base.
	// Il doit faire appel à une méthode qui se trouve dans Services
	// on est obligé de créer un objet à qui on fera appel quand on en aura besoin. 
		
	@GetMapping("/products/{id}")
	// L'annotation @GetMapping signale la présence d'un url (qui complète le premier url)
	// Ex : /products/1 (id du produit 1).
	
	public Object retrieveProduct(@PathVariable long id) {
		// Méthode avec Retour (objet public), nom (choisi librement : retrieveProduct),
		// sachant que retrieve veut dire récupérer, paramètre (id de type long).
				
		Product product = productService.jibProductById(id);
		// Traitement à l'intérieur de la méthode
		// On va créer un objet product de type Product où on va mettre le retour de la méthode jibProductById(id)
		
		// ProductDto productDto = modelMapper.map( product,  ProductDto.class); 
		// La notion de Dto sera expliquée plus loin : donc, négligez cette ligne pour le moment.
		
		return ResponseEntity.status(HttpStatus.OK).body(product);
		// ResponseEntity représente l'ensemble de la réponse HTTP: code de statut, en-têtes et corps . De ce fait, 
		// nous pouvons l’utiliser pour configurer complètement la réponse HTTP.
		// La ligne représente une sorte de contrôle : si le statut est OK, alors envoyer product (body product)
	}
	
	@PostMapping("products")
	public Object addProduct(@Valid @RequestBody Product product) {
		
		Product local_product = productService.zidProduct(product);

		return ResponseEntity.status(HttpStatus.CREATED).body(local_product);
	}
}
