package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Doc;

public interface DocRepository extends JpaRepository<Doc, Integer> {

}