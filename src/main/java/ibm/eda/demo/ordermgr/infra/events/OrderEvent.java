/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package ibm.eda.demo.ordermgr.infra.events;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class OrderEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 694466109163089124L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"OrderEvent\",\"namespace\":\"ibm.eda.demo.ordermgr.infra.events\",\"fields\":[{\"name\":\"orderID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Unique ID from source system\"},{\"name\":\"productID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Unique ID for the product as defined in product catalog\"},{\"name\":\"customerID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Unique ID for the customer organization\"},{\"name\":\"quantity\",\"type\":\"int\",\"doc\":\"Quantity ordered\",\"default\":-1},{\"name\":\"status\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Status of the order.\"},{\"name\":\"creationDate\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"updateDate\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"shippingAddress\",\"type\":{\"type\":\"record\",\"name\":\"Address\",\"fields\":[{\"name\":\"city\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"country\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"state\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"street\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"zipcode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}},{\"name\":\"eventType\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<OrderEvent> ENCODER =
      new BinaryMessageEncoder<OrderEvent>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<OrderEvent> DECODER =
      new BinaryMessageDecoder<OrderEvent>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<OrderEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<OrderEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<OrderEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<OrderEvent>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this OrderEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a OrderEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a OrderEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static OrderEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Unique ID from source system */
  private java.lang.String orderID;
  /** Unique ID for the product as defined in product catalog */
  private java.lang.String productID;
  /** Unique ID for the customer organization */
  private java.lang.String customerID;
  /** Quantity ordered */
  private int quantity;
  /** Status of the order. */
  private java.lang.String status;
  private java.lang.String creationDate;
  private java.lang.String updateDate;
  private ibm.eda.demo.ordermgr.infra.events.Address shippingAddress;
  private java.lang.String eventType;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public OrderEvent() {}

  /**
   * All-args constructor.
   * @param orderID Unique ID from source system
   * @param productID Unique ID for the product as defined in product catalog
   * @param customerID Unique ID for the customer organization
   * @param quantity Quantity ordered
   * @param status Status of the order.
   * @param creationDate The new value for creationDate
   * @param updateDate The new value for updateDate
   * @param shippingAddress The new value for shippingAddress
   * @param eventType The new value for eventType
   */
  public OrderEvent(java.lang.String orderID, java.lang.String productID, java.lang.String customerID, java.lang.Integer quantity, java.lang.String status, java.lang.String creationDate, java.lang.String updateDate, ibm.eda.demo.ordermgr.infra.events.Address shippingAddress, java.lang.String eventType) {
    this.orderID = orderID;
    this.productID = productID;
    this.customerID = customerID;
    this.quantity = quantity;
    this.status = status;
    this.creationDate = creationDate;
    this.updateDate = updateDate;
    this.shippingAddress = shippingAddress;
    this.eventType = eventType;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return orderID;
    case 1: return productID;
    case 2: return customerID;
    case 3: return quantity;
    case 4: return status;
    case 5: return creationDate;
    case 6: return updateDate;
    case 7: return shippingAddress;
    case 8: return eventType;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: orderID = value$ != null ? value$.toString() : null; break;
    case 1: productID = value$ != null ? value$.toString() : null; break;
    case 2: customerID = value$ != null ? value$.toString() : null; break;
    case 3: quantity = (java.lang.Integer)value$; break;
    case 4: status = value$ != null ? value$.toString() : null; break;
    case 5: creationDate = value$ != null ? value$.toString() : null; break;
    case 6: updateDate = value$ != null ? value$.toString() : null; break;
    case 7: shippingAddress = (ibm.eda.demo.ordermgr.infra.events.Address)value$; break;
    case 8: eventType = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'orderID' field.
   * @return Unique ID from source system
   */
  public java.lang.String getOrderID() {
    return orderID;
  }


  /**
   * Sets the value of the 'orderID' field.
   * Unique ID from source system
   * @param value the value to set.
   */
  public void setOrderID(java.lang.String value) {
    this.orderID = value;
  }

  /**
   * Gets the value of the 'productID' field.
   * @return Unique ID for the product as defined in product catalog
   */
  public java.lang.String getProductID() {
    return productID;
  }


  /**
   * Sets the value of the 'productID' field.
   * Unique ID for the product as defined in product catalog
   * @param value the value to set.
   */
  public void setProductID(java.lang.String value) {
    this.productID = value;
  }

  /**
   * Gets the value of the 'customerID' field.
   * @return Unique ID for the customer organization
   */
  public java.lang.String getCustomerID() {
    return customerID;
  }


  /**
   * Sets the value of the 'customerID' field.
   * Unique ID for the customer organization
   * @param value the value to set.
   */
  public void setCustomerID(java.lang.String value) {
    this.customerID = value;
  }

  /**
   * Gets the value of the 'quantity' field.
   * @return Quantity ordered
   */
  public int getQuantity() {
    return quantity;
  }


  /**
   * Sets the value of the 'quantity' field.
   * Quantity ordered
   * @param value the value to set.
   */
  public void setQuantity(int value) {
    this.quantity = value;
  }

  /**
   * Gets the value of the 'status' field.
   * @return Status of the order.
   */
  public java.lang.String getStatus() {
    return status;
  }


  /**
   * Sets the value of the 'status' field.
   * Status of the order.
   * @param value the value to set.
   */
  public void setStatus(java.lang.String value) {
    this.status = value;
  }

  /**
   * Gets the value of the 'creationDate' field.
   * @return The value of the 'creationDate' field.
   */
  public java.lang.String getCreationDate() {
    return creationDate;
  }


  /**
   * Sets the value of the 'creationDate' field.
   * @param value the value to set.
   */
  public void setCreationDate(java.lang.String value) {
    this.creationDate = value;
  }

  /**
   * Gets the value of the 'updateDate' field.
   * @return The value of the 'updateDate' field.
   */
  public java.lang.String getUpdateDate() {
    return updateDate;
  }


  /**
   * Sets the value of the 'updateDate' field.
   * @param value the value to set.
   */
  public void setUpdateDate(java.lang.String value) {
    this.updateDate = value;
  }

  /**
   * Gets the value of the 'shippingAddress' field.
   * @return The value of the 'shippingAddress' field.
   */
  public ibm.eda.demo.ordermgr.infra.events.Address getShippingAddress() {
    return shippingAddress;
  }


  /**
   * Sets the value of the 'shippingAddress' field.
   * @param value the value to set.
   */
  public void setShippingAddress(ibm.eda.demo.ordermgr.infra.events.Address value) {
    this.shippingAddress = value;
  }

  /**
   * Gets the value of the 'eventType' field.
   * @return The value of the 'eventType' field.
   */
  public java.lang.String getEventType() {
    return eventType;
  }


  /**
   * Sets the value of the 'eventType' field.
   * @param value the value to set.
   */
  public void setEventType(java.lang.String value) {
    this.eventType = value;
  }

  /**
   * Creates a new OrderEvent RecordBuilder.
   * @return A new OrderEvent RecordBuilder
   */
  public static ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder newBuilder() {
    return new ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder();
  }

  /**
   * Creates a new OrderEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new OrderEvent RecordBuilder
   */
  public static ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder newBuilder(ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder other) {
    if (other == null) {
      return new ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder();
    } else {
      return new ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder(other);
    }
  }

  /**
   * Creates a new OrderEvent RecordBuilder by copying an existing OrderEvent instance.
   * @param other The existing instance to copy.
   * @return A new OrderEvent RecordBuilder
   */
  public static ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder newBuilder(ibm.eda.demo.ordermgr.infra.events.OrderEvent other) {
    if (other == null) {
      return new ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder();
    } else {
      return new ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder(other);
    }
  }

  /**
   * RecordBuilder for OrderEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OrderEvent>
    implements org.apache.avro.data.RecordBuilder<OrderEvent> {

    /** Unique ID from source system */
    private java.lang.String orderID;
    /** Unique ID for the product as defined in product catalog */
    private java.lang.String productID;
    /** Unique ID for the customer organization */
    private java.lang.String customerID;
    /** Quantity ordered */
    private int quantity;
    /** Status of the order. */
    private java.lang.String status;
    private java.lang.String creationDate;
    private java.lang.String updateDate;
    private ibm.eda.demo.ordermgr.infra.events.Address shippingAddress;
    private ibm.eda.demo.ordermgr.infra.events.Address.Builder shippingAddressBuilder;
    private java.lang.String eventType;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.orderID)) {
        this.orderID = data().deepCopy(fields()[0].schema(), other.orderID);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.productID)) {
        this.productID = data().deepCopy(fields()[1].schema(), other.productID);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.customerID)) {
        this.customerID = data().deepCopy(fields()[2].schema(), other.customerID);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.quantity)) {
        this.quantity = data().deepCopy(fields()[3].schema(), other.quantity);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.status)) {
        this.status = data().deepCopy(fields()[4].schema(), other.status);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.creationDate)) {
        this.creationDate = data().deepCopy(fields()[5].schema(), other.creationDate);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.updateDate)) {
        this.updateDate = data().deepCopy(fields()[6].schema(), other.updateDate);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.shippingAddress)) {
        this.shippingAddress = data().deepCopy(fields()[7].schema(), other.shippingAddress);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (other.hasShippingAddressBuilder()) {
        this.shippingAddressBuilder = ibm.eda.demo.ordermgr.infra.events.Address.newBuilder(other.getShippingAddressBuilder());
      }
      if (isValidValue(fields()[8], other.eventType)) {
        this.eventType = data().deepCopy(fields()[8].schema(), other.eventType);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
    }

    /**
     * Creates a Builder by copying an existing OrderEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(ibm.eda.demo.ordermgr.infra.events.OrderEvent other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.orderID)) {
        this.orderID = data().deepCopy(fields()[0].schema(), other.orderID);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.productID)) {
        this.productID = data().deepCopy(fields()[1].schema(), other.productID);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.customerID)) {
        this.customerID = data().deepCopy(fields()[2].schema(), other.customerID);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.quantity)) {
        this.quantity = data().deepCopy(fields()[3].schema(), other.quantity);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.status)) {
        this.status = data().deepCopy(fields()[4].schema(), other.status);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.creationDate)) {
        this.creationDate = data().deepCopy(fields()[5].schema(), other.creationDate);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.updateDate)) {
        this.updateDate = data().deepCopy(fields()[6].schema(), other.updateDate);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.shippingAddress)) {
        this.shippingAddress = data().deepCopy(fields()[7].schema(), other.shippingAddress);
        fieldSetFlags()[7] = true;
      }
      this.shippingAddressBuilder = null;
      if (isValidValue(fields()[8], other.eventType)) {
        this.eventType = data().deepCopy(fields()[8].schema(), other.eventType);
        fieldSetFlags()[8] = true;
      }
    }

    /**
      * Gets the value of the 'orderID' field.
      * Unique ID from source system
      * @return The value.
      */
    public java.lang.String getOrderID() {
      return orderID;
    }


    /**
      * Sets the value of the 'orderID' field.
      * Unique ID from source system
      * @param value The value of 'orderID'.
      * @return This builder.
      */
    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder setOrderID(java.lang.String value) {
      validate(fields()[0], value);
      this.orderID = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'orderID' field has been set.
      * Unique ID from source system
      * @return True if the 'orderID' field has been set, false otherwise.
      */
    public boolean hasOrderID() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'orderID' field.
      * Unique ID from source system
      * @return This builder.
      */
    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder clearOrderID() {
      orderID = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'productID' field.
      * Unique ID for the product as defined in product catalog
      * @return The value.
      */
    public java.lang.String getProductID() {
      return productID;
    }


    /**
      * Sets the value of the 'productID' field.
      * Unique ID for the product as defined in product catalog
      * @param value The value of 'productID'.
      * @return This builder.
      */
    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder setProductID(java.lang.String value) {
      validate(fields()[1], value);
      this.productID = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'productID' field has been set.
      * Unique ID for the product as defined in product catalog
      * @return True if the 'productID' field has been set, false otherwise.
      */
    public boolean hasProductID() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'productID' field.
      * Unique ID for the product as defined in product catalog
      * @return This builder.
      */
    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder clearProductID() {
      productID = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'customerID' field.
      * Unique ID for the customer organization
      * @return The value.
      */
    public java.lang.String getCustomerID() {
      return customerID;
    }


    /**
      * Sets the value of the 'customerID' field.
      * Unique ID for the customer organization
      * @param value The value of 'customerID'.
      * @return This builder.
      */
    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder setCustomerID(java.lang.String value) {
      validate(fields()[2], value);
      this.customerID = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'customerID' field has been set.
      * Unique ID for the customer organization
      * @return True if the 'customerID' field has been set, false otherwise.
      */
    public boolean hasCustomerID() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'customerID' field.
      * Unique ID for the customer organization
      * @return This builder.
      */
    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder clearCustomerID() {
      customerID = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'quantity' field.
      * Quantity ordered
      * @return The value.
      */
    public int getQuantity() {
      return quantity;
    }


    /**
      * Sets the value of the 'quantity' field.
      * Quantity ordered
      * @param value The value of 'quantity'.
      * @return This builder.
      */
    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder setQuantity(int value) {
      validate(fields()[3], value);
      this.quantity = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'quantity' field has been set.
      * Quantity ordered
      * @return True if the 'quantity' field has been set, false otherwise.
      */
    public boolean hasQuantity() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'quantity' field.
      * Quantity ordered
      * @return This builder.
      */
    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder clearQuantity() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'status' field.
      * Status of the order.
      * @return The value.
      */
    public java.lang.String getStatus() {
      return status;
    }


    /**
      * Sets the value of the 'status' field.
      * Status of the order.
      * @param value The value of 'status'.
      * @return This builder.
      */
    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder setStatus(java.lang.String value) {
      validate(fields()[4], value);
      this.status = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'status' field has been set.
      * Status of the order.
      * @return True if the 'status' field has been set, false otherwise.
      */
    public boolean hasStatus() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'status' field.
      * Status of the order.
      * @return This builder.
      */
    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder clearStatus() {
      status = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'creationDate' field.
      * @return The value.
      */
    public java.lang.String getCreationDate() {
      return creationDate;
    }


    /**
      * Sets the value of the 'creationDate' field.
      * @param value The value of 'creationDate'.
      * @return This builder.
      */
    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder setCreationDate(java.lang.String value) {
      validate(fields()[5], value);
      this.creationDate = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'creationDate' field has been set.
      * @return True if the 'creationDate' field has been set, false otherwise.
      */
    public boolean hasCreationDate() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'creationDate' field.
      * @return This builder.
      */
    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder clearCreationDate() {
      creationDate = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'updateDate' field.
      * @return The value.
      */
    public java.lang.String getUpdateDate() {
      return updateDate;
    }


    /**
      * Sets the value of the 'updateDate' field.
      * @param value The value of 'updateDate'.
      * @return This builder.
      */
    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder setUpdateDate(java.lang.String value) {
      validate(fields()[6], value);
      this.updateDate = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'updateDate' field has been set.
      * @return True if the 'updateDate' field has been set, false otherwise.
      */
    public boolean hasUpdateDate() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'updateDate' field.
      * @return This builder.
      */
    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder clearUpdateDate() {
      updateDate = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'shippingAddress' field.
      * @return The value.
      */
    public ibm.eda.demo.ordermgr.infra.events.Address getShippingAddress() {
      return shippingAddress;
    }


    /**
      * Sets the value of the 'shippingAddress' field.
      * @param value The value of 'shippingAddress'.
      * @return This builder.
      */
    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder setShippingAddress(ibm.eda.demo.ordermgr.infra.events.Address value) {
      validate(fields()[7], value);
      this.shippingAddressBuilder = null;
      this.shippingAddress = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'shippingAddress' field has been set.
      * @return True if the 'shippingAddress' field has been set, false otherwise.
      */
    public boolean hasShippingAddress() {
      return fieldSetFlags()[7];
    }

    /**
     * Gets the Builder instance for the 'shippingAddress' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public ibm.eda.demo.ordermgr.infra.events.Address.Builder getShippingAddressBuilder() {
      if (shippingAddressBuilder == null) {
        if (hasShippingAddress()) {
          setShippingAddressBuilder(ibm.eda.demo.ordermgr.infra.events.Address.newBuilder(shippingAddress));
        } else {
          setShippingAddressBuilder(ibm.eda.demo.ordermgr.infra.events.Address.newBuilder());
        }
      }
      return shippingAddressBuilder;
    }

    /**
     * Sets the Builder instance for the 'shippingAddress' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder setShippingAddressBuilder(ibm.eda.demo.ordermgr.infra.events.Address.Builder value) {
      clearShippingAddress();
      shippingAddressBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'shippingAddress' field has an active Builder instance
     * @return True if the 'shippingAddress' field has an active Builder instance
     */
    public boolean hasShippingAddressBuilder() {
      return shippingAddressBuilder != null;
    }

    /**
      * Clears the value of the 'shippingAddress' field.
      * @return This builder.
      */
    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder clearShippingAddress() {
      shippingAddress = null;
      shippingAddressBuilder = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'eventType' field.
      * @return The value.
      */
    public java.lang.String getEventType() {
      return eventType;
    }


    /**
      * Sets the value of the 'eventType' field.
      * @param value The value of 'eventType'.
      * @return This builder.
      */
    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder setEventType(java.lang.String value) {
      validate(fields()[8], value);
      this.eventType = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'eventType' field has been set.
      * @return True if the 'eventType' field has been set, false otherwise.
      */
    public boolean hasEventType() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'eventType' field.
      * @return This builder.
      */
    public ibm.eda.demo.ordermgr.infra.events.OrderEvent.Builder clearEventType() {
      eventType = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public OrderEvent build() {
      try {
        OrderEvent record = new OrderEvent();
        record.orderID = fieldSetFlags()[0] ? this.orderID : (java.lang.String) defaultValue(fields()[0]);
        record.productID = fieldSetFlags()[1] ? this.productID : (java.lang.String) defaultValue(fields()[1]);
        record.customerID = fieldSetFlags()[2] ? this.customerID : (java.lang.String) defaultValue(fields()[2]);
        record.quantity = fieldSetFlags()[3] ? this.quantity : (java.lang.Integer) defaultValue(fields()[3]);
        record.status = fieldSetFlags()[4] ? this.status : (java.lang.String) defaultValue(fields()[4]);
        record.creationDate = fieldSetFlags()[5] ? this.creationDate : (java.lang.String) defaultValue(fields()[5]);
        record.updateDate = fieldSetFlags()[6] ? this.updateDate : (java.lang.String) defaultValue(fields()[6]);
        if (shippingAddressBuilder != null) {
          try {
            record.shippingAddress = this.shippingAddressBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("shippingAddress"));
            throw e;
          }
        } else {
          record.shippingAddress = fieldSetFlags()[7] ? this.shippingAddress : (ibm.eda.demo.ordermgr.infra.events.Address) defaultValue(fields()[7]);
        }
        record.eventType = fieldSetFlags()[8] ? this.eventType : (java.lang.String) defaultValue(fields()[8]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<OrderEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<OrderEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<OrderEvent>
    READER$ = (org.apache.avro.io.DatumReader<OrderEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.orderID);

    out.writeString(this.productID);

    out.writeString(this.customerID);

    out.writeInt(this.quantity);

    out.writeString(this.status);

    out.writeString(this.creationDate);

    out.writeString(this.updateDate);

    this.shippingAddress.customEncode(out);

    out.writeString(this.eventType);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.orderID = in.readString();

      this.productID = in.readString();

      this.customerID = in.readString();

      this.quantity = in.readInt();

      this.status = in.readString();

      this.creationDate = in.readString();

      this.updateDate = in.readString();

      if (this.shippingAddress == null) {
        this.shippingAddress = new ibm.eda.demo.ordermgr.infra.events.Address();
      }
      this.shippingAddress.customDecode(in);

      this.eventType = in.readString();

    } else {
      for (int i = 0; i < 9; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.orderID = in.readString();
          break;

        case 1:
          this.productID = in.readString();
          break;

        case 2:
          this.customerID = in.readString();
          break;

        case 3:
          this.quantity = in.readInt();
          break;

        case 4:
          this.status = in.readString();
          break;

        case 5:
          this.creationDate = in.readString();
          break;

        case 6:
          this.updateDate = in.readString();
          break;

        case 7:
          if (this.shippingAddress == null) {
            this.shippingAddress = new ibm.eda.demo.ordermgr.infra.events.Address();
          }
          this.shippingAddress.customDecode(in);
          break;

        case 8:
          this.eventType = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










