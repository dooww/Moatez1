package com.example.demo.service;

import main.java.com.example.demo.model.entity.Customer;

public interface CustomerService {
// L'interface est une classe abstraite (dont les méthodes
// et l'implémentation se fait dans les classes filles.
// Théoriquement, on aurait pu créer une classe ProductService
// dans laquelle on aurait créée les méthodes dont on a besoin
// sans recourir à la création d'une interface.
// Mais pour des besoins de décomposition, on a choisi de créer une interface
// dans laquelle on a LES PROTOTYPES des méthodes (et NON les méthodes elles-mêmes);
// celles-ci se trouvant dans l'implémentation.
// On pourra avoir autant de prototypes que de méthodes dont on aura besoin.
// Dans notre cas, étant donné qu'on aura besoin plus tard de 02 méthodes
// get pour récupérer et post pour ajouter, on définiera donc 02 prototypes.

    Customer findCustomerById(Long id);

    // il s'agit du prototype d'une méthode, le contenu de la méthode
    // se trouvant dans l'implémentation. On la nomme librement.
    // Rappelons que la déclaration d'une fonction se fait selon la syntaxe suivante :
    // TypeDeRetour nomDeLaMethode(Type1 argument1, Type2 argument2) {liste d'instructions}
    // Or, dans ce cas précis, il s'agit d'un prototype d'une méthode et non d'une méthode)
    // Par conséquent, la déclaration ne contiendra pas d'instructions.
    // soit Void soit un autre type (soit prédéfini, soit classe comme dans notre cas.
    // affiché grâce la méthode (getProductBy)
    // l'affichage se faisant par l'id, dont le type est un entier long.

    Customer addCustomer(Customer customer);

}
// Mais en fonction de nos besoins ultérieurs, on pourra
// définir autant de prototypes et donc de méthodes que voulus.

