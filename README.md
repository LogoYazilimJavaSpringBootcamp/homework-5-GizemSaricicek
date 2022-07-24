## **HOMEWORK-5**

1. Spring Profile nedir? Properties ya da yml dosya formları ile isbasi uygulamasına test
profile ekleyin.(5 Puan)

Cevap:

Kurumsal uygulamalar geliştirilirken farklı ortamlar kullanılır. Bunlardan bazıları 
“Dev, Test, Stage, Prod” gibi ortamlardır. Her ortamda gerekliliğe göre farklı ayarlamalar 
gerekmektedir. Bu ayarlamaları yönetmek için ortamlarda profil adı verilen 
yapılandırmalar bulunur.
Kullanılan her ortam için application properties dosyası bulunabilir ve uygulamadaki 
profil bu dosyalara göre ayarlanabilir. Profil yönetimini yml uzantılı dosyalar oluşturarak 
da yapabiliriz.

Ortamların app. prop. dosyaları şu şekilde isimlendirilebiliyor:
* application-dev.properties
* application-test.properties
* application-prod.properties


2. SQL injection örnekleyin. Nasıl korunabiliriz?(5 Puan)

Cevap:

Sql Injection, veritabanı içeren sistemler için yaygın olarak görülen bir siber 
güvenlik tehdidir.

Sql Injection -> Web uygulamasının kullandığı sql sorgularına müdahale edilip 
veritabanına ve içerisimndeki verilere yetkisiz erişim olarak özetlenebilir. Bu açık oluşursa 
normalde görülemeyecek veriler görünür hale gelir.
Sql injectionu gerçekleştiren kişi veritabanındaki verileri taşıyabilir, değiştirebilir veya 
silebilir. Kısaca tüm verileri manipüle edebilir.

Örnek: Bir sisteme giriş için kullanıcı adı ve şifre giriliyor olsun. Bu durumun kontrolü için 
şu sql çalıştırılır:

-> Select * from users where user_name=”blabla” and password=”blabla1”

Sql injection ile saldırı yapmak isteyen bir kişi sql sorgusunda değişiklik yapabilir. Mesela 
password bilgisinin sorgusunu kaldırarak giriş yapmayı dener ve başarılı bir şekilde giriş 
yapabilir. Sql sorgusunu şu şekilde değiştirebilir:

-> Select * from users where user_name=”administrator’--” and password=””

Bu şekilde saldırgan yönetici rolü ile veritabanına erişebilir hale gelir.


3. Aşağıdaki kurallara göre bir film öneri uygulaması yazın. (90 Puan)

### **Teknolojiler;**
* Min Java8
* Spring Boot
* Restfull
* MySQL - Postgre - Mongo(Her servis farklı database kullanabilir)
* RabbitMQ

### **Gereksinimler;**

* Kullanıcı sisteme kayıt olup, login olabilmelidir.(Login işlemi için email ve şifre bilgileri
gereklidir.)
* Kullanıcı şifresi istediğiniz bir hashing algoritmasıyla database kaydedilmelidir.
* Kullanıcılar sisteme film ekleyebilir ve bu filmler herkes tarafından görülebilir.
* Kullanıcı kendi eklediği filmleri görebilmeli.(Profil sayfası gibi düşünün)
* Kullanıcı şifresini ve ismini değiştirebilir.
* Ücretli üye olmayan kullanıcılar sadece 3 film ekleyebilir.
* Ücretli üye olmayan kullanıcılar filmlere yorum yapamaz.
* Sisteme yeni bir film girildiğinde kullanıcılara email gider.
* Sistemi takip edebilmek için gerekli gördüğünüz yerlere Log ekleyin.

### **Sistem Kabulleri;**

* Ödeme işlemi senkron gerçekleşmelidir.
* Ödeme servisi sadece ödeme bilgilerini kaydeder ve başarılı response döner.
* Email gönderme işlemi asenkron gerçekleşmelidir.
* Üyelikler 1-3-6-12 ay olarak alınabilir.

### **Ücretlendirme ile ilgili bilgilendirme:**
Sistemde girilen ay değerine göre ödenecek fiyat sistem içerisinden aktarılıyor. (her ay için 20 birim para)
* 1 ay -> 20 (TL, USD, EUR)
* 3 ay -> 60 (TL, USD, EUR)
* 6 ay -> 120 (TL, USD, EUR)
* 12 ay -> 240 (TL, USD, EUR)

### **Postman için bilgiler:**


*Create User

url: (post) http://localhost:1010/users  

body:
{
        "name": "gizem",
        "surname":"sarıçiçek",
        "email":"gizemsaricicek@gmail.com",
        "password":"gizemSaricicek"
}

result:
{
    "id": 2626,
    "name": "gizem",
    "surname": "sarıçiçek",
    "email": "gizemsaricicek@gmail.com",
    "password": "gizemSaricicek"
}


*Get All Users

url: (get) http://localhost:1010/users

result: 
[
    {
        "id": 26,
        "name": "aysun",
        "surname": "yıldız",
        "email": "aysun@gmail.com",
        "password": "aysun123"
    },
    {
        "id": 2587,
        "name": "sinem",
        "surname": "yıldız",
        "email": "sin@gmail.com",
        "password": "123"
    },
{
        "id": 2626,
        "name": "gizem",
        "surname": "sarıçiçek",
        "email": "gizemsaricicek@gmail.com",
        "password": "gizemSaricicek"
    }
]


*Make Payment

url: (post) http://localhost:1010/users/2626/payments

body:
{
        "currencyType":2,
        "month":1
}

result: 
{
    "userId": 2626,
    "paymentDate": "2022-07-24T21:22:23.2561063",
    "currencyType": "EUR",
    "amount": 20.0,
    "month": 1
}

* Update User


url: (put) http://localhost:1010/users/2626/update

body: 
{
        "name": "taha",
        "surname":"akkaya",
        "password":"tahaAkkaya"
}

result:
{
    "id": 2626,
    "name": "taha",
    "surname": "akkaya",
    "email": "gizemsaricicek@gmail.com",
    "password": "tahaAkkaya"
}


* Control Email and Password

url: (get) http://localhost:1010/users/login/gizemsaricicek@gmail.com/tahaAkkaya

result:
{
    "id": 2626,
    "name": "taha",
    "surname": "akkaya",
    "email": "gizemsaricicek@gmail.com",
    "password": "tahaAkkaya"
}


* Add New Film

url: (put) http://localhost:1010/users/2626/addFilm

body:
{
        "name": "harry potter ve sırlar odası",
        "subject":"fantastik",
        "year": 2002
}

result:
{
    "id": 2626,
    "name": "taha",
    "surname": "akkaya",
    "email": "gizemsaricicek@gmail.com",
    "password": "tahaAkkaya"
}


* Get User’s Movies

url: (get) http://localhost:1010/users/2626/films

result:
[
    {
        "id": 2627,
        "name": "harry potter ve sırlar odası",
        "subject": "fantastik",
        "year": 2002
    }
]


* Get All Movies

url: (get) http://localhost:1010/films

result: 
[
    {
        "id": 27,
        "name": "yeşil yol",
        "subject": "dram-fantastik",
        "year": 1999
    },
…
]


* Add New Comment

url: (post) http://localhost:1010/comments/2626/27

body:
{
        "content": "sooo emotional :("
}

result:
{
    "id": 2632,
    "content": "sooo emotional :("
}


* Get Comment By Movie Id

url: (get) http://localhost:1010/comments/27

result:
[
…
    {
        "id": 2632,
        "content": "sooo emotional :("
    }
]


* Delete Comment By Movie Id

url: (delete) http://localhost:1010/comments/2632

result: Comment Deleted!


* Get All Payments

url: (get) http://localhost:1012/payments

result: 
[
…
    {
        "id": 11,
        "userId": 2597,
        "paymentDate": "2022-07-24T21:22:12.870892",
        "currencyType": "EUR",
        "amount": 20.0,
        "month": 1
    },
    {
        "id": 12,
        "userId": 2626,
        "paymentDate": "2022-07-24T21:22:23.256106",
        "currencyType": "EUR",
        "amount": 20.0,
        "month": 1
    }
]
