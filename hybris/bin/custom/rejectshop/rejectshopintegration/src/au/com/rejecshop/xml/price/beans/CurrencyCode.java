//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.24 at 01:03:43 PM IST 
//


package au.com.rejecshop.xml.price.beans;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CurrencyCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CurrencyCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ADP"/>
 *     &lt;enumeration value="AED"/>
 *     &lt;enumeration value="AFA"/>
 *     &lt;enumeration value="ALL"/>
 *     &lt;enumeration value="AMD"/>
 *     &lt;enumeration value="ANG"/>
 *     &lt;enumeration value="AOA"/>
 *     &lt;enumeration value="ARS"/>
 *     &lt;enumeration value="ATS"/>
 *     &lt;enumeration value="AUD"/>
 *     &lt;enumeration value="AWG"/>
 *     &lt;enumeration value="AZM"/>
 *     &lt;enumeration value="BAM"/>
 *     &lt;enumeration value="BBD"/>
 *     &lt;enumeration value="BDT"/>
 *     &lt;enumeration value="BEF"/>
 *     &lt;enumeration value="BGL"/>
 *     &lt;enumeration value="BGN"/>
 *     &lt;enumeration value="BHD"/>
 *     &lt;enumeration value="BIF"/>
 *     &lt;enumeration value="BMD"/>
 *     &lt;enumeration value="BND"/>
 *     &lt;enumeration value="BOB"/>
 *     &lt;enumeration value="BOV"/>
 *     &lt;enumeration value="BRL"/>
 *     &lt;enumeration value="BSD"/>
 *     &lt;enumeration value="BTN"/>
 *     &lt;enumeration value="BWP"/>
 *     &lt;enumeration value="BYR"/>
 *     &lt;enumeration value="BZD"/>
 *     &lt;enumeration value="CAD"/>
 *     &lt;enumeration value="CDF"/>
 *     &lt;enumeration value="CHF"/>
 *     &lt;enumeration value="CLF"/>
 *     &lt;enumeration value="CLP"/>
 *     &lt;enumeration value="CNY"/>
 *     &lt;enumeration value="COP"/>
 *     &lt;enumeration value="CRC"/>
 *     &lt;enumeration value="CUP"/>
 *     &lt;enumeration value="CVE"/>
 *     &lt;enumeration value="CYP"/>
 *     &lt;enumeration value="CZK"/>
 *     &lt;enumeration value="DEM"/>
 *     &lt;enumeration value="DJF"/>
 *     &lt;enumeration value="DKK"/>
 *     &lt;enumeration value="DOP"/>
 *     &lt;enumeration value="DZD"/>
 *     &lt;enumeration value="ECS"/>
 *     &lt;enumeration value="ECV"/>
 *     &lt;enumeration value="EEK"/>
 *     &lt;enumeration value="EGP"/>
 *     &lt;enumeration value="ERN"/>
 *     &lt;enumeration value="ESP"/>
 *     &lt;enumeration value="ETB"/>
 *     &lt;enumeration value="EUR"/>
 *     &lt;enumeration value="FIM"/>
 *     &lt;enumeration value="FJD"/>
 *     &lt;enumeration value="FKP"/>
 *     &lt;enumeration value="FRF"/>
 *     &lt;enumeration value="GBP"/>
 *     &lt;enumeration value="GEL"/>
 *     &lt;enumeration value="GHC"/>
 *     &lt;enumeration value="GIP"/>
 *     &lt;enumeration value="GMD"/>
 *     &lt;enumeration value="GNF"/>
 *     &lt;enumeration value="GRD"/>
 *     &lt;enumeration value="GTQ"/>
 *     &lt;enumeration value="GWP"/>
 *     &lt;enumeration value="GYD"/>
 *     &lt;enumeration value="HKD"/>
 *     &lt;enumeration value="HNL"/>
 *     &lt;enumeration value="HRK"/>
 *     &lt;enumeration value="HTG"/>
 *     &lt;enumeration value="HUF"/>
 *     &lt;enumeration value="IDR"/>
 *     &lt;enumeration value="IEP"/>
 *     &lt;enumeration value="ILS"/>
 *     &lt;enumeration value="INR"/>
 *     &lt;enumeration value="IQD"/>
 *     &lt;enumeration value="IRR"/>
 *     &lt;enumeration value="ISK"/>
 *     &lt;enumeration value="ITL"/>
 *     &lt;enumeration value="JMD"/>
 *     &lt;enumeration value="JOD"/>
 *     &lt;enumeration value="JPY"/>
 *     &lt;enumeration value="KES"/>
 *     &lt;enumeration value="KGS"/>
 *     &lt;enumeration value="KHR"/>
 *     &lt;enumeration value="KMF"/>
 *     &lt;enumeration value="KPW"/>
 *     &lt;enumeration value="KRW"/>
 *     &lt;enumeration value="KWD"/>
 *     &lt;enumeration value="KYD"/>
 *     &lt;enumeration value="KZT"/>
 *     &lt;enumeration value="LAK"/>
 *     &lt;enumeration value="LBP"/>
 *     &lt;enumeration value="LKR"/>
 *     &lt;enumeration value="LRD"/>
 *     &lt;enumeration value="LSL"/>
 *     &lt;enumeration value="LTL"/>
 *     &lt;enumeration value="LUF"/>
 *     &lt;enumeration value="LVL"/>
 *     &lt;enumeration value="LYD"/>
 *     &lt;enumeration value="MAD"/>
 *     &lt;enumeration value="MDL"/>
 *     &lt;enumeration value="MGF"/>
 *     &lt;enumeration value="MKD"/>
 *     &lt;enumeration value="MMK"/>
 *     &lt;enumeration value="MNT"/>
 *     &lt;enumeration value="MOP"/>
 *     &lt;enumeration value="MRO"/>
 *     &lt;enumeration value="MTL"/>
 *     &lt;enumeration value="MUR"/>
 *     &lt;enumeration value="MVR"/>
 *     &lt;enumeration value="MWK"/>
 *     &lt;enumeration value="MXN"/>
 *     &lt;enumeration value="MXV"/>
 *     &lt;enumeration value="MYR"/>
 *     &lt;enumeration value="MZM"/>
 *     &lt;enumeration value="NAD"/>
 *     &lt;enumeration value="NGN"/>
 *     &lt;enumeration value="NIO"/>
 *     &lt;enumeration value="NLG"/>
 *     &lt;enumeration value="NOK"/>
 *     &lt;enumeration value="NPR"/>
 *     &lt;enumeration value="NZD"/>
 *     &lt;enumeration value="OMR"/>
 *     &lt;enumeration value="PAB"/>
 *     &lt;enumeration value="PEN"/>
 *     &lt;enumeration value="PGK"/>
 *     &lt;enumeration value="PHP"/>
 *     &lt;enumeration value="PKR"/>
 *     &lt;enumeration value="PLN"/>
 *     &lt;enumeration value="PTE"/>
 *     &lt;enumeration value="PYG"/>
 *     &lt;enumeration value="QAR"/>
 *     &lt;enumeration value="ROL"/>
 *     &lt;enumeration value="RUB"/>
 *     &lt;enumeration value="RUR"/>
 *     &lt;enumeration value="RWF"/>
 *     &lt;enumeration value="SAR"/>
 *     &lt;enumeration value="SBD"/>
 *     &lt;enumeration value="SCR"/>
 *     &lt;enumeration value="SDD"/>
 *     &lt;enumeration value="SEK"/>
 *     &lt;enumeration value="SGD"/>
 *     &lt;enumeration value="SHP"/>
 *     &lt;enumeration value="SIT"/>
 *     &lt;enumeration value="SKK"/>
 *     &lt;enumeration value="SLL"/>
 *     &lt;enumeration value="SOS"/>
 *     &lt;enumeration value="SRG"/>
 *     &lt;enumeration value="STD"/>
 *     &lt;enumeration value="SVC"/>
 *     &lt;enumeration value="SYP"/>
 *     &lt;enumeration value="SZL"/>
 *     &lt;enumeration value="THB"/>
 *     &lt;enumeration value="TJS"/>
 *     &lt;enumeration value="TMM"/>
 *     &lt;enumeration value="TND"/>
 *     &lt;enumeration value="TOP"/>
 *     &lt;enumeration value="TPE"/>
 *     &lt;enumeration value="TRL"/>
 *     &lt;enumeration value="TTD"/>
 *     &lt;enumeration value="TWD"/>
 *     &lt;enumeration value="TZS"/>
 *     &lt;enumeration value="UAH"/>
 *     &lt;enumeration value="UGX"/>
 *     &lt;enumeration value="USD"/>
 *     &lt;enumeration value="USN"/>
 *     &lt;enumeration value="USS"/>
 *     &lt;enumeration value="UYU"/>
 *     &lt;enumeration value="UZS"/>
 *     &lt;enumeration value="VEB"/>
 *     &lt;enumeration value="VND"/>
 *     &lt;enumeration value="VUV"/>
 *     &lt;enumeration value="WST"/>
 *     &lt;enumeration value="XAF"/>
 *     &lt;enumeration value="XAG"/>
 *     &lt;enumeration value="XAU"/>
 *     &lt;enumeration value="XBA"/>
 *     &lt;enumeration value="XBB"/>
 *     &lt;enumeration value="XBC"/>
 *     &lt;enumeration value="XCD"/>
 *     &lt;enumeration value="XDR"/>
 *     &lt;enumeration value="XFO"/>
 *     &lt;enumeration value="XFU"/>
 *     &lt;enumeration value="XOF"/>
 *     &lt;enumeration value="XPD"/>
 *     &lt;enumeration value="XPF"/>
 *     &lt;enumeration value="XPT"/>
 *     &lt;enumeration value="XTS"/>
 *     &lt;enumeration value="YER"/>
 *     &lt;enumeration value="YUM"/>
 *     &lt;enumeration value="ZAR"/>
 *     &lt;enumeration value="ZMK"/>
 *     &lt;enumeration value="ZWD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CurrencyCode")
@XmlEnum
public enum CurrencyCode {


    /**
     * Andorran Peseta
     * 
     */
    ADP,

    /**
     * UAE Dirham
     * 
     */
    AED,

    /**
     * Afghani
     * 
     */
    AFA,

    /**
     * Leck
     * 
     */
    ALL,

    /**
     * Armenian Dram
     * 
     */
    AMD,

    /**
     * Netherlands Antillan Guilder
     * 
     */
    ANG,

    /**
     * Kwanza
     * 
     */
    AOA,

    /**
     * Argentine Peso
     * 
     */
    ARS,

    /**
     * Schilling
     * 
     */
    ATS,

    /**
     * Australian Dollar
     * 
     */
    AUD,

    /**
     * Aruban Guilder
     * 
     */
    AWG,

    /**
     * Azerbaijanian Manat
     * 
     */
    AZM,

    /**
     * Convertible Marks
     * 
     */
    BAM,

    /**
     * Barbados Dollar
     * 
     */
    BBD,

    /**
     * Taka
     * 
     */
    BDT,

    /**
     * Belgian Franc
     * 
     */
    BEF,

    /**
     * Lev
     * 
     */
    BGL,

    /**
     * Bulgarian Lev
     * 
     */
    BGN,

    /**
     * Bahraini Dinar
     * 
     */
    BHD,

    /**
     * Burundi Franc
     * 
     */
    BIF,

    /**
     * Bermudian Dollar
     * 
     */
    BMD,

    /**
     * Brunei Dollar
     * 
     */
    BND,

    /**
     * Boliviano
     * 
     */
    BOB,

    /**
     * Mvdol
     * 
     */
    BOV,

    /**
     * Brazilian Real
     * 
     */
    BRL,

    /**
     * Bahamian Dollar
     * 
     */
    BSD,

    /**
     * Ngultrum
     * 
     */
    BTN,

    /**
     * Pula
     * 
     */
    BWP,

    /**
     * Belarussian Ruble
     * 
     */
    BYR,

    /**
     * Belize Dollar
     * 
     */
    BZD,

    /**
     * Canadian Dollar
     * 
     */
    CAD,

    /**
     * Franc Congolais
     * 
     */
    CDF,

    /**
     * Swiss Franc
     * 
     */
    CHF,

    /**
     * Unidades de fomento
     * 
     */
    CLF,

    /**
     * Chilean Peso
     * 
     */
    CLP,

    /**
     * Yuan Renminbi
     * 
     */
    CNY,

    /**
     * Colombian Peso
     * 
     */
    COP,

    /**
     * Costa Rican Colon
     * 
     */
    CRC,

    /**
     * Cuban Peso
     * 
     */
    CUP,

    /**
     * Cape Verde Escudo
     * 
     */
    CVE,

    /**
     * Cyprus Pound
     * 
     */
    CYP,

    /**
     * Czech Koruna
     * 
     */
    CZK,

    /**
     * Deutsche Mark
     * 
     */
    DEM,

    /**
     * Djibouti Franc
     * 
     */
    DJF,

    /**
     * Danish Krone
     * 
     */
    DKK,

    /**
     * Dominican Peso
     * 
     */
    DOP,

    /**
     * Algerian Dinar
     * 
     */
    DZD,

    /**
     * Sucre
     * 
     */
    ECS,

    /**
     * Unidad de Valor Constante (UVC)
     * 
     */
    ECV,

    /**
     * Kroon
     * 
     */
    EEK,

    /**
     * Egyptian Pound
     * 
     */
    EGP,

    /**
     * Nakfa
     * 
     */
    ERN,

    /**
     * Spanish Peseta
     * 
     */
    ESP,

    /**
     * Ethiopian Birr
     * 
     */
    ETB,

    /**
     * euro
     * 
     */
    EUR,

    /**
     * Markka
     * 
     */
    FIM,

    /**
     * Fiji Dollar
     * 
     */
    FJD,

    /**
     * Falkland Islands Pound
     * 
     */
    FKP,

    /**
     * French Franc
     * 
     */
    FRF,

    /**
     * Pound Sterling
     * 
     */
    GBP,

    /**
     * Lari
     * 
     */
    GEL,

    /**
     * Cedi
     * 
     */
    GHC,

    /**
     * Gibraltar Pound
     * 
     */
    GIP,

    /**
     * Dalasi
     * 
     */
    GMD,

    /**
     * Guinea Franc
     * 
     */
    GNF,

    /**
     * Drachma
     * 
     */
    GRD,

    /**
     * Quetzal
     * 
     */
    GTQ,

    /**
     * Guinea-Bissau Peso
     * 
     */
    GWP,

    /**
     * Guyana Dollar
     * 
     */
    GYD,

    /**
     * Hong Kong Dollar
     * 
     */
    HKD,

    /**
     * Lempira
     * 
     */
    HNL,

    /**
     * Croatian kuna
     * 
     */
    HRK,

    /**
     * Gourde
     * 
     */
    HTG,

    /**
     * Forint
     * 
     */
    HUF,

    /**
     * Rupiah
     * 
     */
    IDR,

    /**
     * Irish Pound
     * 
     */
    IEP,

    /**
     * New Israeli Sheqel
     * 
     */
    ILS,

    /**
     * Indian Rupee
     * 
     */
    INR,

    /**
     * Iraqi Dinar
     * 
     */
    IQD,

    /**
     * Iranian Rial
     * 
     */
    IRR,

    /**
     * Iceland Krona
     * 
     */
    ISK,

    /**
     * Italian Lira
     * 
     */
    ITL,

    /**
     * Jamaican Dollar
     * 
     */
    JMD,

    /**
     * Jordanian Dinar
     * 
     */
    JOD,

    /**
     * Yen
     * 
     */
    JPY,

    /**
     * Kenyan Shilling
     * 
     */
    KES,

    /**
     * Som
     * 
     */
    KGS,

    /**
     * Riel
     * 
     */
    KHR,

    /**
     * Comoro Franc
     * 
     */
    KMF,

    /**
     * North Korean Won
     * 
     */
    KPW,

    /**
     * Won
     * 
     */
    KRW,

    /**
     * Kuwaiti Dinar
     * 
     */
    KWD,

    /**
     * Cayman Islands Dollar
     * 
     */
    KYD,

    /**
     * Tenge
     * 
     */
    KZT,

    /**
     * Kip
     * 
     */
    LAK,

    /**
     * Lebanese Pound
     * 
     */
    LBP,

    /**
     * Sri Lanka Rupee
     * 
     */
    LKR,

    /**
     * Liberian Dollar
     * 
     */
    LRD,

    /**
     * Loti
     * 
     */
    LSL,

    /**
     * Lithuanian Litus
     * 
     */
    LTL,

    /**
     * Luxembourg Franc
     * 
     */
    LUF,

    /**
     * Latvian Lats
     * 
     */
    LVL,

    /**
     * Lybian Dinar
     * 
     */
    LYD,

    /**
     * Moroccan Dirham
     * 
     */
    MAD,

    /**
     * Moldovan Leu
     * 
     */
    MDL,

    /**
     * Malagasy Franc
     * 
     */
    MGF,

    /**
     * Denar
     * 
     */
    MKD,

    /**
     * Kyat
     * 
     */
    MMK,

    /**
     * Tugrik
     * 
     */
    MNT,

    /**
     * Pataca
     * 
     */
    MOP,

    /**
     * Ouguiya
     * 
     */
    MRO,

    /**
     * Maltese Lira
     * 
     */
    MTL,

    /**
     * Mauritius Rupee
     * 
     */
    MUR,

    /**
     * Rufiyaa
     * 
     */
    MVR,

    /**
     * Kwacha
     * 
     */
    MWK,

    /**
     * Mexican Peso
     * 
     */
    MXN,

    /**
     * Mexican Unidad de Inversion (UDI)
     * 
     */
    MXV,

    /**
     * Malaysian Ringgit
     * 
     */
    MYR,

    /**
     * Metical
     * 
     */
    MZM,

    /**
     * Namibia Dollar
     * 
     */
    NAD,

    /**
     * Naira
     * 
     */
    NGN,

    /**
     * Cordoba Oro
     * 
     */
    NIO,

    /**
     * Netherlands Guilder
     * 
     */
    NLG,

    /**
     * Norvegian Krone
     * 
     */
    NOK,

    /**
     * Nepalese Rupee
     * 
     */
    NPR,

    /**
     * New Zealand Dollar
     * 
     */
    NZD,

    /**
     * Rial Omani
     * 
     */
    OMR,

    /**
     * Balboa
     * 
     */
    PAB,

    /**
     * Nuevo Sol
     * 
     */
    PEN,

    /**
     * Kina
     * 
     */
    PGK,

    /**
     * Philippine Peso
     * 
     */
    PHP,

    /**
     * Pakistan Rupee
     * 
     */
    PKR,

    /**
     * Zloty
     * 
     */
    PLN,

    /**
     * Portuguese Escudo
     * 
     */
    PTE,

    /**
     * Guarani
     * 
     */
    PYG,

    /**
     * Qatari Rial
     * 
     */
    QAR,

    /**
     * Leu
     * 
     */
    ROL,

    /**
     * Russian Ruble
     * 
     */
    RUB,

    /**
     * Russian Ruble
     * 
     */
    RUR,

    /**
     * Rwanda Franc
     * 
     */
    RWF,

    /**
     * Saudi Riyal
     * 
     */
    SAR,

    /**
     * Solomon Islands Dollar
     * 
     */
    SBD,

    /**
     * Seychelles Rupee
     * 
     */
    SCR,

    /**
     * Sudanese Dinar
     * 
     */
    SDD,

    /**
     * Swedish Krona
     * 
     */
    SEK,

    /**
     * Singapore Dollar
     * 
     */
    SGD,

    /**
     * Saint Helena Pound
     * 
     */
    SHP,

    /**
     * Tolar
     * 
     */
    SIT,

    /**
     * Slovak Koruna
     * 
     */
    SKK,

    /**
     * Leone
     * 
     */
    SLL,

    /**
     * Somali Shilling
     * 
     */
    SOS,

    /**
     * Suriname Guilder
     * 
     */
    SRG,

    /**
     * Dobra
     * 
     */
    STD,

    /**
     * El Salvador Colon
     * 
     */
    SVC,

    /**
     * Syrian Pound
     * 
     */
    SYP,

    /**
     * Lilangeni
     * 
     */
    SZL,

    /**
     * Baht
     * 
     */
    THB,

    /**
     * Somoni
     * 
     */
    TJS,

    /**
     * Manat
     * 
     */
    TMM,

    /**
     * Tunisian Dinar
     * 
     */
    TND,

    /**
     * Pa�anga
     * 
     */
    TOP,

    /**
     * Timor Escudo
     * 
     */
    TPE,

    /**
     * Turkish Lira
     * 
     */
    TRL,

    /**
     * Trinidad and Tobago Dollar
     * 
     */
    TTD,

    /**
     * New Taiwan Dollar
     * 
     */
    TWD,

    /**
     * Tanzanian Shilling
     * 
     */
    TZS,

    /**
     * Hryvnia
     * 
     */
    UAH,

    /**
     * Uganda Shilling
     * 
     */
    UGX,

    /**
     * US Dollar
     * 
     */
    USD,

    /**
     * US Dollar (Next day)
     * 
     */
    USN,

    /**
     * US Dollar (Same day)
     * 
     */
    USS,

    /**
     * Peso Uruguayo
     * 
     */
    UYU,

    /**
     * Uzbekistan Sum
     * 
     */
    UZS,

    /**
     * Bolivar
     * 
     */
    VEB,

    /**
     * Dong
     * 
     */
    VND,

    /**
     * Vatu
     * 
     */
    VUV,

    /**
     * Tala
     * 
     */
    WST,

    /**
     * CFA Franc BEAC
     * 
     */
    XAF,

    /**
     * Silver
     * 
     */
    XAG,

    /**
     * Gold
     * 
     */
    XAU,

    /**
     * European Monetary Unit (E.M.U.-6)
     * 
     */
    XBA,

    /**
     * European Unit of Account 9 (E.U.A.-9)
     * 
     */
    XBB,

    /**
     * European Unit of Account 17 (E.U.A.-17)
     * 
     */
    XBC,

    /**
     * East Caribbean Dollar
     * 
     */
    XCD,

    /**
     * SDR
     * 
     */
    XDR,

    /**
     * Gold-Franc
     * 
     */
    XFO,

    /**
     * UIC-Franc
     * 
     */
    XFU,

    /**
     * CFA Franc BCEAO
     * 
     */
    XOF,

    /**
     * Palladium
     * 
     */
    XPD,

    /**
     * CFP Franc
     * 
     */
    XPF,

    /**
     * Platinum
     * 
     */
    XPT,

    /**
     * Codes Specifically reserved for testing
     *                     purposes
     * 
     */
    XTS,

    /**
     * Yemeni Rial
     * 
     */
    YER,

    /**
     * Yugoslavian Dinar
     * 
     */
    YUM,

    /**
     * South Africa Rand
     * 
     */
    ZAR,

    /**
     * Kwacha
     * 
     */
    ZMK,

    /**
     * Zimbabwe Dollar
     * 
     */
    ZWD;

    public String value() {
        return name();
    }

    public static CurrencyCode fromValue(String v) {
        return valueOf(v);
    }

}
