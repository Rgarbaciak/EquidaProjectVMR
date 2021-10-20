/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.CategVente;
import model.Cheval;
import model.Client;
import model.Pays;
import model.TypeCheval;

/**
 *
 * @author adminsio
 */
public class FormCheval {
    private String resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public void setErreurs(Map<String, String> erreurs) {
        this.erreurs = erreurs;
    }
    
    //méthode de validation du champ de saisie nom
    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.length() < 3 ) {
        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }

    private void setErreur( String champ, String message ) {
    erreurs.put(champ, message );
    }    
    
    private static String getDataForm( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }   
    }
     public Cheval ajouterCheval( HttpServletRequest request ) {
      
        Cheval unCheval  = new Cheval();
         
        String nom = getDataForm( request, "Nom" );
        String sexe = getDataForm( request, "Sexe");
        String sire = getDataForm( request, "Sire" );
        String dateNaissance = getDataForm( request, "DateDeNaissance");
        String poids = getDataForm( request, "Poids" );
        String libelleRace = getDataForm( request, "TypeCheval");
        String pere = getDataForm( request, "pere" );
        int pereC = Integer.parseInt(pere);
        String mere = getDataForm( request, "mere");
        int mereC = Integer.parseInt(mere);
      
        // Traitement de la liste à choix multiple
        //Pour chq catégorie selectionné, on instancie une nouvelle catégorie et on l'ajoute au client
        try {
             validationNom( nom );
        } catch ( Exception e ) {
            setErreur( "nom", e.getMessage() );
        }
        unCheval.setNom(nom);

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }
         
      
        unCheval.setSexe(sexe);
        unCheval.setSire(sire);
        unCheval.setDateNaissance(dateNaissance);
        unCheval.setPoids(poids);
        
        TypeCheval race = new TypeCheval();
        race.setLibelle(libelleRace);
        unCheval.setUnTypeCheval(race);
        
        Cheval ChePere = new Cheval();
        ChePere.setId(pereC);
        unCheval.setPere(ChePere);
        
        Cheval CheMere = new Cheval();
        CheMere.setId(mereC);
        unCheval.setMere(CheMere);
        
        
        return unCheval ;
    }
     
      public Cheval updateCheval ( HttpServletRequest request ) {
      
        Cheval unCheval  = new Cheval();
        String idChevalString = getDataForm(request,"che_id"); 
        int che_id = Integer.parseInt(idChevalString);  
        String nom = getDataForm( request, "Nom" );
        String sexe = getDataForm( request, "Sexe");
        String sire = getDataForm( request, "Sire" );
        String dateNaissance = getDataForm( request, "DateDeNaissance");
        String poids = getDataForm( request, "Poids" );
        String libelleRace = getDataForm( request, "TypeCheval");
        String pere = getDataForm( request, "pere" );
        int pereC = Integer.parseInt(pere);
        String mere = getDataForm( request, "mere");
        int mereC = Integer.parseInt(mere);
      
        // Traitement de la liste à choix multiple
        //Pour chq catégorie selectionné, on instancie une nouvelle catégorie et on l'ajoute au client
        try {
             validationNom( nom );
        } catch ( Exception e ) {
            setErreur( "nom", e.getMessage() );
        }
        unCheval.setNom(nom);

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }
         
      
        unCheval.setSexe(sexe);
        unCheval.setSire(sire);
        unCheval.setDateNaissance(dateNaissance);
        unCheval.setPoids(poids);
        
        TypeCheval race = new TypeCheval();
        race.setLibelle(libelleRace);
        unCheval.setUnTypeCheval(race);
        
        Cheval ChePere = new Cheval();
        ChePere.setId(pereC);
        unCheval.setPere(ChePere);
        
        Cheval CheMere = new Cheval();
        CheMere.setId(mereC);
        unCheval.setMere(CheMere);
        unCheval.setId(che_id);
        
        
        return unCheval ;
    }
}
