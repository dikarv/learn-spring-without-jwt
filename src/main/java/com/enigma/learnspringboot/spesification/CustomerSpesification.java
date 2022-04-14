package com.enigma.learnspringboot.spesification;

import com.enigma.learnspringboot.dto.CustomersSearchDTO;
import com.enigma.learnspringboot.entity.Customer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CustomerSpesification {//bikin class

    public static Specification<Customer> getSpesification(CustomersSearchDTO customersSearchDTO) {
        //static harus di instiate panggil classs
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();//yang dimasukin adalah query dari first name dan last name
                //search firts name
                //rara - >  predicates
                //build query mengspesifikasi fata yang akan dicari
                if (customersSearchDTO.getSearchCustomerFirstName() != null) {
                    Predicate querySeleksiCustomerDiMasukinkePredicate = criteriaBuilder.like(root.get("firstname"),
                            "%" + customersSearchDTO.getSearchCustomerFirstName().toLowerCase(Locale.ROOT));
                    predicates.add(querySeleksiCustomerDiMasukinkePredicate);
                }
                //serach last name
                //hasil query pencarian dimasukin ke array list predicates
                if (customersSearchDTO.getGetSearchCustomerLastName() != null) {
                    Predicate customersLastNamePredicate = criteriaBuilder.like(root.get("lastname"),
                            "%" + customersSearchDTO.getGetSearchCustomerLastName().toLowerCase(Locale.ROOT));
                    predicates.add(customersLastNamePredicate);
                }
                Predicate[] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicate);
            }

        };
    }
}
