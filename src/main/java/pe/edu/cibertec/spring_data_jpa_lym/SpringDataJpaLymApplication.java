package pe.edu.cibertec.spring_data_jpa_lym;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.cibertec.spring_data_jpa_lym.entity.Customer;
import pe.edu.cibertec.spring_data_jpa_lym.entity.Film;
import pe.edu.cibertec.spring_data_jpa_lym.repository.CustomerRepository;
import pe.edu.cibertec.spring_data_jpa_lym.repository.FilmRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringDataJpaLymApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    FilmRepository filmRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaLymApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        /**
         * save()
         */
//        Customer customer = new Customer(null, 1, "César", "Torres", "torres@mail.com", 1, 1, new Date(), new Date());
//        customerRepository.save(customer);

        /**
         * findById() - get()
         */
//        Optional<Customer> optional = customerRepository.findById(632);
//        Customer customer = optional.get();
//        System.out.println(customer);

        /**
         * findById() - orElse()
         */
//        Optional<Customer> optional = customerRepository.findById(632);
//        Customer customer = optional.orElse(null);
//        System.out.println(customer);

        /**
         * findById() - orElseGet()
         */
//        Optional<Customer> optional = customerRepository.findById(631);
//        Customer customer = optional.orElseGet(() -> {
//            LocalDate today = LocalDate.now();
//            System.out.println("Customer not found: " + today);
//            return null;
//        });
//        System.out.println(customer);

        /**
         * findById() - orElseThrow()
         */
//        Optional<Customer> optional = customerRepository.findById(632);
////        Customer customer = optional.orElseThrow(() -> {
////            return new IllegalArgumentException();
////        });
//        Customer customer = optional.orElseThrow(IllegalArgumentException::new);
//        System.out.println(customer);

        /**
         * isPresent()
         */
//        Optional<Customer> optional = customerRepository.findById(632);
//        if (optional.isPresent()) {
//            System.out.println(optional.get());
//        } else {
//            System.out.println("Customer not found");
//        }

        /**
         * ifPresent()
         */
//        Optional<Customer> optional = customerRepository.findById(631);
//        optional.ifPresent((customer) -> {
//            LocalDate today = LocalDate.now();
//            System.out.println("Fecha: " + today);
//            System.out.println(customer.getFirst_name() + " " + customer.getLast_name());
//        });

        /**
         * ifPresentOrElse()
         */
//        Optional<Customer> optional = customerRepository.findById(631);
//        optional.ifPresentOrElse(
//                (item) -> {
//                    System.out.println(String.format("Customer is %s", item.getEmail()));
//                },
//                () -> {
//                    System.out.println("Customer not found");
//                }
//        );

        /**
         * existById()
         */
//        if (customerRepository.existsById(632)) {
//            System.out.println("Customer exist");
//        } else {
//            System.out.println("Customer not exist");
//        }

        /**
         * findAll()
         */
//        Iterable<Customer> iterable = customerRepository.findAll();

        // for clasico
//        for (Customer customer : iterable) {
//            System.out.println(customer);
//        }

        // forEach - Referencia al metodo
//        iterable.forEach(System.out::println);

        // forEach - Referencia al metodo
//        iterable.forEach((variable) -> {
//            System.out.println(variable.getLast_name());
//        });

        /**
         * List.copyOf()
         */
//        List<Customer> lista = List.copyOf((Collection<Customer>) iterable);

        /**
         * findAllById()
         */
//        Iterable<Integer> ids = List.of(620, 621, 622);
//        Iterable<Customer> iterable = customerRepository.findAllById(ids);
//        iterable.forEach(System.out::println);

        /**
         * deleteById()
         */
//        int id = 631;
//        if (customerRepository.existsById(id)) {
//            customerRepository.deleteById(id);
//        } else {
//            System.out.println("Customer with id " + id + " does not exist");
//        }

        /**
         * deleteAllById()
         */
//        List<Integer> lista = List.of(621, 622, 623);
////        lista.stream().filter((item) -> {
////            return customerRepository.existsById(item);
////        }).collect(Collectors.toList());
//        lista.stream().filter(customerRepository::existsById).collect(Collectors.toList());
//
//        customerRepository.deleteAllById(lista);

        /**
         * delete()
         */
//        Optional<Customer> optional = customerRepository.findById(620);
//        optional.ifPresentOrElse(
//                (customer) -> {
//                    customerRepository.delete(customer);
//                },
//                () -> {
//                    System.out.println("Customer not found");
//                });

        /**
         * deleteAll()
         */
//        Iterable<Customer> iterable = customerRepository.findAllById(List.of(618, 619, 620, 621));
//        customerRepository.deleteAll(iterable);

        /**
         * findAll() - Caching
         */
        System.out.println("-----------------------------------------------------");
        System.out.println("findAll() - 1ra llamada a MySQL");
        System.out.println("-----------------------------------------------------");
        Iterable<Film> iterable = filmRepository.findAll();
        iterable.forEach((film) -> {
            System.out.print(String.format("%s:%s;", film.getFilm_id(), film.getTitle()));
        });

        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("findAll() - 2da llamada a MySQL");
        System.out.println("-----------------------------------------------------");
        Iterable<Film> iterable2 = filmRepository.findAll();
        iterable2.forEach((film) -> {
            System.out.print(String.format("%s:%s;", film.getFilm_id(), film.getTitle()));
        });

        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("save() - 3ra llamada a MySQL");
        System.out.println("-----------------------------------------------------");
        Optional<Film> optional = filmRepository.findById(1);
        optional.ifPresentOrElse(
                (film) -> {
                    film.setTitle("BATMAN RETURNS");
                    filmRepository.save(film);
                },
                () -> {
                    System.out.println("Film not found");
                }
        );

        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("findAll() - 4ta llamada a MySQL");
        System.out.println("-----------------------------------------------------");
        Iterable<Film> iterable3 = filmRepository.findAll();
        iterable3.forEach((film) -> {
            System.out.print(String.format("%s:%s;", film.getFilm_id(), film.getTitle()));
        });

    }

}
