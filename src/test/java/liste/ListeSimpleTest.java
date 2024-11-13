package liste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires pour la classe ListeSimple.
 * Ces tests couvrent les fonctionnalités de base de la liste chaînée simple.
 */
class ListeSimpleTest {

    ListeSimple listeATester;

    /**
     * Initialise la liste avant chaque test.
     */
    @BeforeEach
    public void init() {
        listeATester = new ListeSimple();
    }

    /**
     * Teste la construction d'une liste vide.
     * Vérifie que la tête de la liste est null et que la taille est 0.
     */
    @Test
    void listeConstruiteVide() {
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    /**
     * Teste que l'ajout d'un élément augmente la taille de la liste.
     */
    @Test
    void ajoutAugmenteSize() {
        listeATester.ajout(1);
        assertEquals(1, listeATester.getSize());
    }

    /**
     * Teste que l'ajout d'un élément modifie la tête de la liste.
     */
    @Test
    void ajoutChangeTete() {
        listeATester.ajout(1);
        Noeud teteApresPremierAjout = listeATester.tete;
        listeATester.ajout(1);
        assertNotNull(teteApresPremierAjout);
        assertNotSame(teteApresPremierAjout, listeATester.tete);
    }

    /**
     * Teste l'ajout plusieurs fois du même élément.
     * Vérifie que la taille augmente correctement.
     */
    @Test
    void ajoutPlusieursFoisLeMeme() {
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.ajout(1);
        assertEquals(3, listeATester.getSize());
    }

    /**
     * Teste la méthode toString() pour vérifier la représentation correcte des noeuds de la liste.
     */
    @Test
    void toStringDonneTousLesNoeuds() {
        System.out.println(listeATester);
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        System.out.println(listeATester);

        assertEquals("ListeSimple(Noeud(3), Noeud(2), Noeud(1))", listeATester.toString());
    }

    /**
     * Teste la modification du premier élément de la liste.
     * Vérifie que la méthode modifie correctement l'élément.
     */
    @Test
    void modifiePremier() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.modifiePremier(2, 4);
        assertEquals("ListeSimple(Noeud(3), Noeud(4), Noeud(1))", listeATester.toString());
        assertEquals(4, listeATester.tete.getSuivant().getElement());
    }

    /**
     * Teste la modification du premier élément lorsque l'élément n'est pas trouvé dans la liste.
     */
    @Test
    void testModifiePremierElementNotFound() {
        listeATester.ajout(1);
        listeATester.ajout(2);

        listeATester.modifiePremier(3, 10);

        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
    }

    /**
     * Teste la modification d'un élément dans une liste vide.
     */
    @Test
    void testModifiePremierEmptyList() {
        listeATester = new ListeSimple();

        listeATester.modifiePremier(1, 10);

        assertNull(listeATester.tete);
    }

    /**
     * Teste la modification de tous les éléments identiques dans la liste.
     */
    @Test
    void modifieTous() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.modifieTous(1, 4);
        assertEquals("ListeSimple(Noeud(4), Noeud(4), Noeud(2), Noeud(4))", listeATester.toString());
        assertEquals(4, listeATester.tete.getSuivant().getElement());
    }

    /**
     * Teste la suppression du premier élément lorsque cet élément est en première position.
     */
    @Test
    void supprimePremierEnPremierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimePremier(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    /**
     * Teste l'échange de deux noeuds identiques (aucun changement attendu).
     */
    @Test
    void echangerMemeNoeud() {
        listeATester.ajout(1);
        Noeud r1 = listeATester.tete;
        listeATester.echanger(r1, r1);
        assertEquals("ListeSimple(Noeud(1))", listeATester.toString());
    }

    /**
     * Teste l'échange de noeuds où l'un des noeuds est la tête de la liste.
     */
    @Test
    void echangerNoeudR2EstTete() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        listeATester.ajout(3);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r1 = listeATester.tete.getSuivant();

        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))", listeATester.toString());

        listeATester.echanger(r1, r2);
        assertEquals("ListeSimple(Noeud(1), Noeud(3), Noeud(2), Noeud(4), Noeud(5))", listeATester.toString());
    }

    /**
     * Teste la suppression du premier élément dans une liste avec plusieurs éléments.
     */
    @Test
    void supprimePremierEnPositionQuelconque() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(2);
        assertEquals("ListeSimple(Noeud(4), Noeud(3), Noeud(1))", listeATester.toString());
        assertEquals(3, listeATester.getSize());
    }

    /**
     * Teste la suppression du premier élément qui est en dernière position.
     */
    @Test
    void supprimePremierEnDernierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(1);
        assertEquals("ListeSimple(Noeud(4), Noeud(3), Noeud(2))", listeATester.toString());
        assertEquals(3, listeATester.getSize());
    }

    /**
     * Teste la suppression de tous les éléments dans une liste vide.
     */
    @Test
    void supprimeTousListeVide() {
        listeATester.supprimePremier(1);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    /**
     * Teste la suppression de tous les éléments avec un seul élément à supprimer en début de liste.
     */
    @Test
    void supprimeTousUneSeuleFoisAuDebut() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimeTous(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    /**
     * Teste la suppression de tous les éléments avec un seul élément à supprimer en position quelconque.
     */
    @Test
    void supprimeTousUneSeuleFoisPositionQuelconque() {
        listeATester.ajout(1);
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.supprimeTous(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    /**
     * Teste la suppression de plusieurs occurrences du même élément.
     */
    @Test
    void supprimeTousPlusieursFois() {
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.supprimeTous(1);
        assertEquals("ListeSimple(Noeud(2))", listeATester.toString());
        assertEquals(1, listeATester.getSize());
    }

    @Test
    void supprimeTousPlusieursFoisPositionQuelconque() {
        listeATester.ajout(3);
        listeATester.ajout(1);
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.supprimeTous(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    @Test
    void avantDernierListeVide() {
        assertNull(listeATester.getAvantDernier());
    }

    @Test
    void avantDernierListeAUnElement() {
        listeATester.ajout(1);
        assertNull(listeATester.getAvantDernier());
    }

    @Test
    void avantDernierListeADeuxElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }

    @Test
    void avantDernierListeAPlusieursElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }

    @Test
    void inverserListeVide() {
        listeATester.inverser();
        assertNull(listeATester.tete);
    }

    @Test
    void inverserListeNbPairDElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.inverser();
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4))", listeATester.toString());
    }

    @Test
    void inverserListeNbImPairDElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.inverser();
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3))", listeATester.toString());
    }

    @Test
    void echanger2NoeudsQuelconques() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(1);
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))", listeATester.toString());
        listeATester.echanger(r1, r2);
        assertEquals("ListeSimple(Noeud(1), Noeud(4), Noeud(3), Noeud(2), Noeud(5))", listeATester.toString());
    }

    @Test
    void echangerLePremierNoeudAvecUnAutre() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r1 = listeATester.tete;
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))", listeATester.toString());
        listeATester.echanger(r1, r2);
        System.out.println(listeATester);
        assertEquals("ListeSimple(Noeud(4), Noeud(2), Noeud(3), Noeud(1), Noeud(5))", listeATester.toString());
    }

    @Test
    void echangerLePremierEnSecondArgumentNoeudAvecUnAutre() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r2 = listeATester.tete;
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))", listeATester.toString());
        listeATester.echanger(r1, r2);
        System.out.println(listeATester);
        assertEquals("ListeSimple(Noeud(4), Noeud(2), Noeud(3), Noeud(1), Noeud(5))", listeATester.toString());
    }
    @Test
    void testSupprimePremierElementNotFound() {
        // Setup list
        listeATester.ajout(1);
        listeATester.ajout(2);

        // Essayer de supprimer un élément qui n'existe pas (élément 3)
        listeATester.supprimePremier(3);

        // Vérifier que la liste reste inchangée
        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
    }


    @Test
    void testSupprimePremierEmptyList() {
        // Setup empty list
        listeATester = new ListeSimple();

        // Essayer de supprimer un élément d'une liste vide
        listeATester.supprimePremier(1);

        // Vérifier que la liste est toujours vide
        assertNull(listeATester.tete);
    }


}