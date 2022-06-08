Kitap Listeleme Programı
------------------------- 
->Kullanılanlar:
 * MsSql, JavaFX
 * mssql-jdbc-10.2.1.jre17 Driver Kullanıldı.
 NOT: Kullanmak için MsSql.java classındaki url kullanılan bilgisayara göre değiştirilmeli

->Program
 * Ana Sayfa (Film Ekleme): 
	Film Verilerini kullanıcıdan alıp, 
	mssql veritabanında(mbp106_filmListele) bağlanıp seçilen listenin tablosuna film verisini aktarır.
 * Film Sil:
	Filmin bulunduğu liste seçildikten sonra, ismi belirtilir, eğer veri tabanında tabloda varsa
	tabloadan veri silinir.
 * İzlediklerim Liste ve İzleyeceklerim Liste Sayfaları:
	Veri tabanında bulunan geçerli listelerde kayıtlı olan verilerden bulunan verilerdeki
	verileri alıp tabloya aktarır.