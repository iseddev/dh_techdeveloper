package MesaTrabajo_01;

public abstract class State {

    // Puede estar en alguno de los siguientes estados[State] (sólo uno a la vez)
    // Vacío => IsEmpty
    // Cargando => IsLoading
    // Pagando => IsPaying
    // Cerrado => IsClosed


    // ##### También se le pueden indicar las siguientes instrucciones #####

    // Agregar un producto al carrito[ShoppingCart] (pasándole como parámetro al método un Objeto de tipo Producto[Item])
    public abstract void addProduct(Item item);

    // Cancelar el carrito (vuelve a estar vacío[IsEmpty])
    public abstract void cancelPurchase();

    // Volver al punto anterior (salvo que esté cerrado[IsClosed])
    public abstract void backPreviousPoint();

    // Pasar al siguiente estado (en el caso de estar cerrado[IsClosed], vuelve a estar vacío[IsEmpty])
    public abstract void goNextState();

    @Override
    public String toString() { return "State:"; }
}
