package com.vcs.form;

public class transfer {

   private int _id;
   private String _name;
   private String _dob;
   private String _address;
   private int _phno;
   private String _emailid;
   private int _occuid;

   public transfer(){}

    public transfer (int id,String name,String dob,String address,int phno,String emailid,int occuid)
    {
        this._id=id;
        this._name=name;
        this._dob=dob;
        this._address=address;
        this._phno=phno;
        this._emailid=emailid;
        this._occuid=occuid;
    }

   public transfer (String name,String dob,String address,int phno,String emailid,int occuid)
   {
       this._name=name;
       this._dob=dob;
       this._address=address;
       this._phno=phno;
       this._emailid=emailid;
       this._occuid=occuid;
   }

    //Setters
    public void set_id(int _id)
    {
        this._id=_id;
    }

    public void set_name(String _name)
    {
        this._name=_name;
    }

    public void set_dob(String _dob)
    {
        this._dob=_dob;
    }

    public void set_address(String _address)
    {
        this._address=_address;
    }

    public void set_phno(int _phno) { this._phno=_phno; }

    public void set_emailid(String _emailid)
    {
        this._emailid=_emailid;
    }

    public void set_occuid(int _occuid)
    {
        this._occuid=_occuid;
    }


    //Getters
    public int get_id() { return _id;}

    public String get_name() { return _name;}

    public String get_dob() { return _dob;}

    public String get_address() { return _address;}

    public int get_phno() { return _phno;}

    public String get_emailid() { return _emailid;}

    public int get_occuid() { return _occuid;}

}
