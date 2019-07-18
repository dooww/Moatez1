// Voir l'explication détaillée dans le fichier Excel

package main.java.com.example.demo.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table (name = "PRODUCT")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product implements Serializable {


	@Id 
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  
	  @Column(name="ID") 
	  private Long id;
      
	  @Column(name="NOM")
	  private String name;
	  
	  @Column(name="PRIX")
	  private Float price;
	  
	  @Column(name="QUANTITE")
      private Integer quantity;
	  
    
}
// 1 Création de la classe
// 2 Création des attributs
// 3 Création automatique de la table @Entity
// 4 Indication de l'identifiant de la table @Id
// 5 Incrémentation automatique de l'Id :  @GeneratedValue(strategy=GenerationType.IDENTITY) IDENTITY veut dire +1
// 6 Incrémentation automatique de la classe en ajoutant la sérialisation de la classe
//     implements Serializable
// 7 Indication du nom de la table et des noms des colonnes : @Table, etc, @Colum, etc
// 8 Création des getters et setters : @Data
// 9 Création des constructeurs : @allArgConstructor, @NoArgConstructor