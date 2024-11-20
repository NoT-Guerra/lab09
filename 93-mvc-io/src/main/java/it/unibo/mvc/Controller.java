package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
/**
 * @throws NullPointerException
*/
void setNextString() throws NullPointerException;
/**
 *
 */
void getNextString();
/**
 *@return List<String>
*/
List<String> getPrintedString();
/**
 * @throws IllegalStateException
*/
void printCurrentString() throws IllegalStateException;
}
