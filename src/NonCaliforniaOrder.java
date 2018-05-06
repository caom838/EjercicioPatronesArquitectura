public class NonCaliforniaOrder implements Order {
  private double orderAmount;
  
  public NonCaliforniaOrder() {
  }
  public NonCaliforniaOrder(double inp_orderAmount) {
    orderAmount = inp_orderAmount;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public void accept(VisitorInterface v) {
    v.visit(this);
  }
  
  	/**
  	 *  Metodo para obtener el total de la orden de noncalifornia
  	 *  @return valor total
  	 */
	@Override
	public double getTotalAmount() {
		
		return this.getOrderAmount();
	}
}
