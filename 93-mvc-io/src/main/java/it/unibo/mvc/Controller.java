package it.unibo.mvc;

/**
 *
 */
public interface Controller {
void setNextString() throws NullPointerException;
void getNextString();
void getPrintedString();
void printCurrentString() throws IllegalStateException;
}
