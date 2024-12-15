# E-Commerce App - Full Stack Development Project  

**Backend:** Java, Spring Boot | **Frontend:** React.js, TypeScript, Vite, SWC | **Database:** MySQL | **Deployment:** Docker | **API Testing:** Postman, Swagger UI  

---

## Proje Özeti  

Bu proje, tam anlamıyla bir E-Commerce uygulaması olarak geliştirilmiştir. Hem backend hem de frontend geliştirme süreçlerinde modern teknolojiler kullanılarak yüksek performanslı ve ölçeklenebilir bir yapıda oluşturulmuştur. Spring Boot ve React.js gibi güçlü araçlarla uygulamanın güvenilirliği ve performansı ön plana çıkmaktadır.

---

## 1. Proje Hakkında (Overview)

### Kullanılan Teknolojiler  

**Backend:**  
- Spring Boot, Maven 3, Java 17  

**Frontend:**  
- React.js, TypeScript, Vite, SWC  

**Database:**  
- MySQL Workbench  

**Containerization:**  
- Docker  

**API Testing:**  
- Swagger UI, Postman  

### Projenin Temel Özellikleri  
- Güçlü backend yapısı: Entity, Model, Mapper, Repository, Service, Controller, Config, Exception ve Security katmanları kullanıldı.  
- Modern frontend geliştirme: React.js ve TypeScript ile hızlı ve optimize bir arayüz oluşturuldu.  
- MySQL veritabanı entegrasyonu ve Docker ile kolay deployment sağlandı.  

---

## 2. Teknik Bilgiler (Technical Details)

### Backend Yapısı  

- Maven 3 ve Spring Boot kullanıldı.  
- Dependency Management için aşağıdaki teknolojiler ve paketler kullanıldı:  
  - Spring Boot Starter Data JPA  
  - Spring Boot Starter Web  
  - MySQL Connector  
  - Lombok  
  - Springdoc OpenAPI Starter WebMVC UI  
  - Spring Boot Starter Data Redis  
  - Spring Boot Starter Security  
  - JJWT API  
  - JJWT Impl  
  - JJWT Jackson  
  - MapStruct  
  - MapStruct Processor  

### Frontend Yapısı  

- Modern React.js altyapısı kullanıldı.  
- TypeScript ile statik tip kontrolü sağlandı.  
- Hızlı build ve optimizasyon için Vite ve SWC tercih edildi.  

### Database  

- MySQL Workbench ile veritabanı tasarımı yapıldı.  
- Spring Boot Data JPA ve Hibernate kullanılarak veritabanı işlemleri gerçekleştirildi.  

### API Testing  

- Swagger UI ve Postman kullanılarak REST API endpointleri test edildi.  

---

## 3. Kullanım (Usage)  

- Kullanıcıların ürünleri listeleyebilmesi, sepete ekleyebilmesi ve satın alabilmesi sağlandı.  
- Yönetici paneli üzerinden ürün ekleme, silme ve güncelleme işlemleri yapılabilir.  
- Güçlü güvenlik altyapısı ve JWT ile kullanıcı doğrulama mekanizması kullanıldı.  

---

## 4. Öne Çıkan Özellikler (Key Features)  

- Modüler ve temiz backend yapısı: Entity, Model, Mapper, Repository, Service katmanlarıyla sürdürülebilir geliştirme.  
- React.js ile hızlı ve optimize frontend geliştirme.  
- Docker kullanarak uygulamanın hızlı bir şekilde deployment ve taşınabilirliği.  
- Swagger UI üzerinden API dokümantasyonu ve Postman ile test edilebilir API endpointleri.  
- Güçlü güvenlik yapısı için Spring Security ve JWT doğrulaması.  

---  

## 5. Kurulum (Setup)

### Docker Çalıştırma  
- Docker Compose kullanarak uygulamayı çalıştırmak için komutu kullanın: `docker-compose up -d`  
- Bu komut, projenin gerekli tüm servislerini arka planda başlatır.

### Swagger UI Kullanımı  
Swagger UI üzerinden API dokümantasyonuna erişmek için aşağıdaki adresi tarayıcınıza yazın:  
- [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)
- Swagger UI, API endpointlerini testlemek ve dokümantasyonu görüntülemek için kullanılır.

### Frontend Kurulumu  
- React.js ve TypeScript projesini başlatmak için aşağıdaki adımları takip edin:

1. **Vite Projesini oluşturma:**  
   - `npm create vite@latest`  
2. **Gerekli paketleri yükleme:**  
   - `npm install`  
3. **Proje başlatma:**  
   - `npm run dev` veya `npm start`  

- Vite kullanarak hızlı ve optimize bir build süreci sağlanır. Ayrıca SWC tercih edilerek performans iyileştirilmiştir.


### Material-UI Paketleri  
Frontend geliştirme için Material-UI kullanıldı. Yüklenen paketler:  

- `npm install @mui/material @emotion/react @emotion/styled`  
- `npm install @fontsource/roboto`  
- `npm install @mui/icons-material`  
- `npm i axios`  
- `npm i react-toastify`  
- `npm i redux react-redux`  
- `npm install @reduxjs/toolkit`  
- `npm i @paralleldrive/cuid2`  
- `npm i @mui/lab`  
- `npm install react-hook-form`  
- `npm i yup`  
- `npm install @hookform/resolvers yup`  

- **Bu paketler, hızlı UI bileşenleri, state yönetimi, form doğrulaması ve API istekleri gibi özellikleri destekler.**

### Backend Maven Kurulumu  

- Maven projenin kök klasöründe olduğunuzdan emin olun.  
- Maven bağımlılıklarını yüklemek ve projeyi çalıştırmak için: `mvn clean install`  

- **Bu adım, backend için gerekli bağımlılıkları yükler ve projeyi derleyerek çalıştırılabilir hale getirir. Maven, Spring Boot projelerinde dependency yönetimi ve build işlemlerini kolaylaştırır.**

---

## 6. Demo ve Ekran Görüntüleri (Demo & Screenshots)

Proje, backend ve frontend sistemlerini hızlı ve verimli bir şekilde çalıştırarak test edilebilir durumda tasarlandı.

- **Backend**: Spring Boot uygulamasını çalıştırın ve veritabanı bağlantısını doğrulayın. Swagger UI üzerinden tüm API endpointlerini testleyebilirsiniz.
- **Frontend**: React.js uygulamasını hızlı build ve optimizasyon araçları (Vite ve SWC) kullanarak çalıştırın. Kullanıcı arayüzünü ve etkileşimleri testleyin.

---

## 7. Katkıda Bulunanlar ve Kaynaklar (Contributors & Resources)  

- **Proje Sahibi:** [Batuhan Baysal](https://www.linkedin.com/in/batuhan-baysal-502656170/)  

- **Kaynaklar:**  
  - Spring Boot Resmi Dokümantasyonu  
  - React.js Resmi Dokümantasyonu  
  - MySQL Documentation  
  - Docker Resmi Dokümantasyonu  
  - Swagger UI Resmi Dokümantasyonu  
  - Postman Documentation  

---

## 8. İletişim ve Destek (Contact & Support)

- **LinkedIn**: [Batuhan Baysal LinkedIn Profilim](https://www.linkedin.com/in/batuhan-baysal-502656170/)

- **Github**: [Batuhan Baysal GitHub Profilim](https://github.com/BatuhanBaysal)
