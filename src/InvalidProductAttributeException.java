package src;

/**
 * Package 'src'
 *
 * Zweck: Exception Klasse für ungültige oder unzureichende Produkt Attribute
 * @author: Maximilian Böhme
 * @version: 01.06.2023
 * Historie: 01.06.2023, Erstellung der Klasse
 */
public class InvalidProductAttributeException extends Exception{
    /**
     * Der Zweck der Exception
     * @param message Die Nachricht, die an den Nutzer gemeldet wird, wenn diese Exception ausgeüfhrt wird
     */
    public InvalidProductAttributeException(String message) {
        super(message);
    }
}
