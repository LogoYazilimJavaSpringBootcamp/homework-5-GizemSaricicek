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
