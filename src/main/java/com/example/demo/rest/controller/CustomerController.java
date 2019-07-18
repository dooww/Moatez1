package com.example.demo.rest.controller;

import main.java.com.example.demo.model.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
// on ajoute l'annotation @RestController pour dire au compilateur que la classe
// suivante ProductController est un controller (cad : webservice).
// En même temps, on a désigné un premier url (après /) à ce contrôleur.

public class CustomerController {
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

    private CustomerService customerService;
    // Bien entendu, le Controller ne peut pas aller directement à la base.
    // Il doit faire appel à une méthode qui se trouve dans Services
    // on est obligé de créer un objet à qui on fera appel quand on en aura besoin.

    @GetMapping("/customers/{id}")
    // L'annotation @GetMapping signale la présence d'un url (qui complète le premier url)
    // Ex : /products/1 (id du produit 1).

    public Object retrieveCustomer(@PathVariable long id) {
        // Méthode avec Retour (objet public), nom (choisi librement : retrieveProduct),
        // sachant que retrieve veut dire récupérer, paramètre (id de type long).

        Customer customer = customerService.findCustomerById(id);
        // Traitement à l'intérieur de la méthode
        // On va créer un objet product de type Product où on va mettre le retour de la méthode jibProductById(id)

        // ProductDto productDto = modelMapper.map( product,  ProductDto.class);
        // La notion de Dto sera expliquée plus loin : donc, négligez cette ligne pour le moment.

        return ResponseEntity.status(HttpStatus.OK).body(customer);
        // ResponseEntity représente l'ensemble de la réponse HTTP: code de statut, en-têtes et corps . De ce fait,
        // nous pouvons l’utiliser pour configurer complètement la réponse HTTP.
        // La ligne représente une sorte de contrôle : si le statut est OK, alors envoyer product (body product)
    }


/*
    @RequestMapping("/hello")
    public  String hello(){return("hello there");}

*/



    @PostMapping("/customers")
    public Object addCustomer(@Valid @RequestBody Customer customer) {

        Customer local_customer = customerService.addCustomer(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(local_customer);
    }
}