package com.drimsys.library;

import java.util.Scanner;
import com.drimsys.connection.MongoDBConnection;
import com.mongodb.client.MongoDatabase;

public class Library {
    public static void main(String[] args) {
        MongoDatabase database = MongoDBConnection.connect();
        BookManager manager = new BookManager(database);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== 도서 관리 시스템 ===");
            System.out.println("1. 책 추가");
            System.out.println("2. 책 목록 보기");
            System.out.println("3. 책 검색");
            System.out.println("4. 책 정보 수정");
            System.out.println("5. 책 삭제");
            System.out.println("6. 종료");
            System.out.print("선택: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // 버퍼 비우기

            switch (choice) {
                case 1:
                    manager.addBook();
                    break;
                case 2:
                    manager.viewBooks();
                    break;
                case 3:
                    manager.searchBook();
                    break;
                case 4:
                	manager.updateBook();
                	break;
                case 5:
                    manager.deleteBook();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }
}
