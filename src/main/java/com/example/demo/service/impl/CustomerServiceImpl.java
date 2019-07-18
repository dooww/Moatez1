package com.example.demo.service.impl;

import main.java.com.example.demo.model.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
//L'annotation @Service permet de déclarer un bean de service

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    // @autowired est le fait de "dire" à Spring qu'une instance d'un objet dans un bean1
    // peut être recherchée dans une autre instance d'un bean 2 (injection des dépendances).

    // C’est une annotation qui nous permet de faire l’injection de dépendances entre les beans
    // de l’application (Spring va tout faire), il suffit juste d’annoter un constructeur
    // ou une méthode avec cette dernière et le conteneur Spring va faire la suite : creation
    // du bean, le chercher et l’injecter automatiquement….
    // Autrement dit, sans l'annotation @Autowired, l'objet (en bleu) ne peut pas être instancé.

    private CustomerRepository customerrep;
    // Il faut déclarer le Repository de la classe ProductRepository et lui donner un nom
    // Repository doit être défini hors de la méthode pour pouvoir l'utiliser partout.

    @Override
    // L'annotation @override est utilisé pour définir une méthode qui est héritée de
    // la classe parente. On ne l'utilise donc que dans le cas de l'héritage. En plaçant
    // ce mot-clé dans le commentaire de la méthode réécrite, le compilateur vérifiera que
    // la méthode est correctement utilisée (mêmes arguments, même type de valeur de retour)
    // et affichera un message d'avertissement si ce n'est pas le cas.
    // Dans notre cas, la méthode JibProduct va hériter son corps
    // de la méthode Product jibProductById(Long id);

    public Customer findCustomerById(Long id) {
        // On réécrit le prototype de la méthode définie dans Product Service

        return customerrep.findById(id).get();
    }
    // Mais, on doit faire appel à  productrepository qui contient la méthode (findById)
    // qui va retourner un product.

    @Override
    // On fait appel de nouveau à l'annotation @Override
    // car on doit (comme déjà dit) la méthode déjà prototypée dans ProductService,
    // à savoir : Product zidProduct(Product product);

    @Transactional
    // L'annotation @Transactional peut être utilisée pour indiquer au conteneur
    // les méthodes qui doivent s'exécuter dans un contexte transactionnel,
    // cad que Spring permet de gérer le contexte transactionnel de différentes
    // API comme JDBC, Java Transaction API (JTA), Java Persistence API (JPA)
    // afin qu’ils fonctionnent bien ensemble.

    public Customer addCustomer(Customer customer) {
        return customerrep.save(customer);

        // Explication : on aurait pu écrire la même chose d'une autre manière :
        // Product p = productrep.save(product);
        // return p;

    }

}
