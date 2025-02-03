package com.drimsys.library;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class BookManager {
    private final MongoCollection<Document> bookCollection;

    public BookManager(MongoDatabase database) {
        this.bookCollection = database.getCollection("books");
    }
    
    //책 추가하기
    public void addBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("책 제목: ");
        String title = scanner.nextLine();

        System.out.print("저자: ");
        String author = scanner.nextLine();

        System.out.print("출판 연도: ");
        String year = scanner.nextLine();

        Document book = new Document("title", title)
                .append("author", author)
                .append("year", year);

        bookCollection.insertOne(book);
        System.out.println("책이 추가되었습니다.");
    }
    
    //책 목록보기
    public void viewBooks() {
        FindIterable<Document> books = bookCollection.find();
        for (Document book : books) {
            System.out.println("제목: " + book.getString("title"));
            System.out.println("저자: " + book.getString("author"));
            System.out.println("출판 연도: " + book.getString("year"));
            System.out.println("-----------------------");
        }
    }
    
    //책 목록 찾기
    public void searchBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("검색할 책 제목: ");
        String title = scanner.nextLine();

        Document query = new Document("title", title);
        Document book = bookCollection.find(query).first();

        if (book != null) {
            System.out.println("제목: " + book.getString("title"));
            System.out.println("저자: " + book.getString("author"));
            System.out.println("출판 연도: " + book.getString("year"));
        } else {
            System.out.println("해당 책을 찾을 수 없습니다.");
        }
    }
    
    public void updateBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("수정할 책 제목: ");
        String title = scanner.nextLine();

        // 제목으로 문서 검색
        Document found = bookCollection.find(Filters.eq("title", title)).first();
        if (found == null) {
            System.out.println("해당 제목의 책이 존재하지 않습니다.");
            return;
        }

        System.out.println("수정한 책 제목: ");
        String updateTitle = scanner.nextLine();
        System.out.println("수정한 책 저자: ");
        String updateAuthor = scanner.nextLine();
        System.out.println("수정한 책 출판연도: ");
        String updateYear = scanner.nextLine();  // 문자열을 정수로 변환

        // 문서 업데이트
        bookCollection.updateOne(
            Filters.eq("title", title),
            Updates.combine(
                Updates.set("title", updateTitle),
                Updates.set("author", updateAuthor),
                Updates.set("year", updateYear)
            )
        );

        System.out.println("수정되었습니다.");
    }
    
    //책목록 삭제
    public void deleteBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("삭제할 책 제목: ");
        String title = scanner.nextLine();
        
        Document found = bookCollection.find(Filters.eq("title", title)).first();
        if (found == null) {
            System.out.println("해당 제목의 책이 존재하지 않습니다.");
            return;
        }

        Document query = new Document("title", title);
        bookCollection.deleteOne(query);
        System.out.println("책이 삭제되었습니다.");
    }


}


