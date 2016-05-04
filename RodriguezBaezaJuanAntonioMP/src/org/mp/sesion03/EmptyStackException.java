package org.mp.sesion03;

@SuppressWarnings("serial")
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
