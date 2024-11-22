package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
/**
 * @throws NullPointerException
 * @param nextString
 *
*/
void setNextString(String nextString);
/**
 *@return String
 */
 String getNextString();
/**
 *@return List<String>
*/
List<String> getPrintedString();
/**
 * @throws IllegalStateException
*/
void printCurrentString();
}
