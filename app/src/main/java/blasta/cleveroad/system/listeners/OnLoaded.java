package blasta.cleveroad.system.listeners;

/**
 * Created by 1 on 15.12.2014.
 */
public interface OnLoaded<T> {
    public void successLoading(T data);
    public void failedLoading (Exception e);
}
