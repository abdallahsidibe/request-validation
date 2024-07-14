## Validation des requêtes entrantes dans Spring Boot : Focus sur la validation au niveau du DTO
Dans le développement d'applications Web, la validation des données entrantes est d'une importance capitale pour garantir la sécurité, l'intégrité et la cohérence des informations traitées. Spring Boot, framework Java populaire pour la création de microservices, offre un mécanisme robuste de validation des requêtes HTTP, notamment au niveau des objets de transfert de données (DTO).

### Qu'est-ce qu'un DTO ?

Un objet de transfert de données (DTO) est un objet léger utilisé pour transférer des données entre différentes couches d'une application. Il encapsule les données pertinentes pour une opération spécifique, en les dissociant des détails d'implémentation sous-jacents.

### Pourquoi valider les DTO ?

La validation des DTO apporte plusieurs avantages :

Sécurité: Elle permet de protéger l'application contre des injections de code malveillant ou des données non conformes.

Intégrité: Elle garantit que les données reçues respectent les formats et les contraintes attendus.

Cohérence: Elle assure une communication claire et précise entre les différentes couches de l'application.

### Comment valider les DTO dans Spring Boot ?

Spring Boot utilise le framework de validation JSR 380, implémenté par défaut par Hibernate Validator. Pour valider un DTO, il suffit d'annoter ses propriétés avec les annotations appropriées, telles que :

@NotNull: Indique que la propriété ne doit pas être null.

@Size(min = 5, max = 10): Indique que la propriété doit avoir une longueur entre 5 et 10 caractères.

@Pattern(regexp = "[A-Za-z]+"): Indique que la propriété doit contenir uniquement des lettres majuscules ou minuscules.

@Email: Indique que la propriété doit respecter le format d'une adresse e-mail valide.

@NotBlank

@FutureOrPresent

@Positive

@Past

@PastOrPresent

@Pattern

@PositiveOrZero
...
Explorer le import jakarta.validation.constraints.*;

#### Exemple de validation d'un DTO

Considérons un DTO Utilisateur avec les propriétés nom, prenom et email:

    @Data
    public class Utilisateur {

        @NotNull
        private String nom;

        @NotNull
        private String prenom;

        @Email
        private String email;
    }



##### Annotation @Valid pour la validation

Pour activer la validation du DTO dans un contrôleur Spring MVC, il faut annoter le paramètre @RequestBody avec l'annotation @Valid:

    @PostMapping("/creerUtilisateur")
    public void creerUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
    // Traitement de l'utilisateur validé
    }

#### Add validation
Hibernate Validator provides built-in constraints that will use to validate our input. To see the full list check out this link below

https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-builtin-constraints


#### Gestion des erreurs de validation

En cas d'échec de la validation, Spring Boot lève une exception MethodArgumentNotValidException. On peut intercepter cette exception pour renvoyer des messages d'erreur personnalisés à l'utilisateur.

Configuration CORS pour les requêtes inter-domaines

Pour autoriser les requêtes HTTP inter-domaines (CORS), il faut configurer Spring Boot en conséquence. Cela permet aux applications clientes situées sur des domaines différents d'accéder aux ressources de l'API.

La configuration CORS peut être effectuée dans un fichier de configuration dédié ou directement dans la classe de configuration principale de l'application. Voici un exemple de configuration CORS dans un fichier dédié :


    @Configuration
    @EnableWebMvc
    public class CorsConfig extends WebMvcConfigurerAdapter {

      @Override
       public void addCorsMappings(CorsConfigurationSource config) {
         CorsConfiguration cors = new CorsConfiguration();
         cors.setAllowedOrigins(Arrays.asList("https://domaine-client1.com", "https://domaine-client2.com"));
         cors.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
         cors.setAllowedHeaders(Arrays.asList("*"));
         cors.setAllowCredentials(true);
         config.applyCorsConfigurations(cors);
      }

## Conclusion

La validation des requêtes entrantes dans Spring Boot, en particulier au niveau des DTO, est un élément crucial pour garantir la robustesse et la fiabilité d'une application Web. En utilisant les annotations de validation JSR 380 et en configurant correctement CORS, les développeurs peuvent s'assurer que leurs API sont sécurisées et accessibles de manière contrôlée.

#### Sources
medium.com/@ritika590/conquering-cors-issue-in-react-app-5e60c6031a3f

## Beautiful database diagrams
https://drawsql.app/