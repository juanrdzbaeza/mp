package org.mp.sesion04;

public class EmptyStackException extends Exception
{
    /**
     * Constructor para la excepcion.
     * @param inicializa con mensaje de la expecption
     */
    public EmptyStackException(String error)
    {
        super( error );
    }
}
