# Team application

Zabezpiecznie strony certyfikatem ssl

- Wykorzystać narzędzie keytool z Javy - tylko do lokalnego developmentu 
```sql
$ keytool.exe -genkey -alias team -storetype PKCS12 -keyalg RSA\
 -keysize 2048 -keystore team-keystore.p12 -validity 3650\
  -dname "CN=Krzysztof Ukleja, OU=Risk, O=BankCompany, L=Gdansk, ST=Pomerania, C=PL"\
   -keypass haslo1234 -storepass haslo1234
```
- Ustawić Springa Boota, aby przekierorywał wszystko na https - haseł oczywiście nie wysyłąć na gita 
```sql
server:
  port: 443
  ssl:
    enabled: true
    key-alias: team
    key-store: "team-keystore.p12"
    key-store-type: PKCS12
    key-store-password: haslo1234
    key-password: haslo1234
```
- wygenerowanie CSR (Certificate Singning Request) w example_pl.crs oraz keystore w example_pl.jks
```sql
keytool -genkey -alias server -keyalg RSA -keysize 2048 -keystore example_pl.jks -dname "CN=example.pl,OU=IT, O=Krzysztof Ukleja, L=Gdansk, ST=pomorskie, C=PL" && keytool -certreq -alias server -file example_pl.csr -keystore example_pl.jks
```
Następnie CSR można wysłać do instytucji wydajęcej certyfikaty
https://secure.instantssl.com/products/SSLIdASignup1a

