package com.example.todolist;

import com.example.todolist.note.Note;
import com.example.todolist.note.NoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TodoListApplication {

    @Bean
    CommandLineRunner setTestData(NoteRepository repo){
        return args -> {
            repo.save(new Note("스프링부트 1주차","프로젝트를 생성하였습니다", "2018-06-04"));
            repo.save(new Note("스프링부트 2주차","기본적인 CRUD를 구현하였습니다.", "2018-06-11"));
            repo.save(new Note("스프링부트 3주차","보안 기능을 추가하였습니다.", "2018-06-18"));
            repo.save(new Note("스프링부트 4주차","추가 기능을 구현하였습니다.", "2018-06-25"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(TodoListApplication.class, args);
    }
}
