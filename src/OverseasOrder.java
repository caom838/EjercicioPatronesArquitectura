public class OverseasOrder implements Order {
  private double orderAmount;
  private double additionalSH;

  public OverseasOrder() {
  }
  public OverseasOrder(double inp_orderAmount,
      double inp_additionalSH) {
    orderAmount = inp_orderAmount;
    additionalSH = inp_additionalSH;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalSH() {
    return additionalSH;
  }
  
  /**
   * metodo para aceptar la visita del visitador
   */
  public void accept(VisitorInterface v) {
    v.visit(this);
  }
  
  /**
   * Metodo para obtener el total de la orden de overseas
   * @return
   */
  public double getTotalAmount()
  {
	  return (this.getOrderAmount() + this.getAdditionalSH());
  }
  
}
