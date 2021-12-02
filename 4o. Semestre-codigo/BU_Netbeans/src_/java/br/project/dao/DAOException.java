package  br.project.dao;


/**
 * SIGMAH - Sistema de Geração Manual e Automática de Horários
 * 
 * @author Wonder Alexandre Luz Alves<br>
 * @date: 16/10/2006
 * <b>Descricao:</b><br>
 * Excecao da camada DAO
 */
public class DAOException extends Exception {

    private static final long serialVersionUID = 1L;

    protected Exception exception;

    /**
     * Creates a new DAOException wrapping another exception, and with a detail message.
     *
     * @param message   the detail message.
     * @param exception the wrapped exception.
     */
    public DAOException(String message, Exception exception) {
        super(message);
        this.exception = exception;
        return;
    }

    /**
     * Creates a DAOException with the specified detail message.
     *
     * @param message the detail message.
     */
    public DAOException(String message) {
        this(message, null);
        return;
    }

    /**
     * Creates a new DAOException wrapping another exception, and with no detail message.
     *
     * @param exception the wrapped exception.
     */
    public DAOException(Exception exception) {
        this(null, exception);
        return;
    }

    /**
     * Gets the wrapped exception.
     *
     * @return the wrapped exception.
     */
    public Exception getException() {
        return exception;
    }


}
