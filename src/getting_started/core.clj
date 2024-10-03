(ns getting-started.core
  (:gen-class)
(:require [clojure.math :as math]) )

; COMMENT
(comment
;; exists in namespace
; pattern matching on name and arguments, modular
(defn hello
  ([] "Hello World") ; if no argument
  ([name]            ; if argument
   (str "Hello " name)) ; last part of the function def is always returned so return is implicit
  )

(def drinks ["Coke" "Fanta"])

(defn can-drink? [age]
  (if (> age 18)
    (conj drinks "Beer")
    (conj drinks "Sprite"))
  )

(let [a "b"]) ; variable binding in this scope not def

(can-drink? 15)
(hello "Richard")
(can-drink? 43)
drinks ; no side effects. drinks are not mutable
) ; COMMENTS!

(defn fact
   ([n] (fact n 1))
   ([n accumulator]
    (if (zero? n)
      accumulator
      (recur (dec n) (* accumulator n)) )) )

(defn isItPrime
  ([N] (isItPrime N N 1 (math/sqrt N) ))        ; Start with divisor p = 2 and limit as sqrt(N)
  ([N M p limit]
   (cond
     (<= M 1) false                                ; Numbers <= 1 are not prime
     (and (> M 1) (<= M 3)) true                   ;  
     (> p limit) true                              ; If p exceeds sqrt(N), N is prime
     (and (zero? (mod M p)) (>= p 2)) (== N 2)     ; If N is divisible by p, it's not prime
     :else (recur (dec N) M (inc p) limit))))      ; Otherwise, check the next divisor

(defn fermatNumber
  ([n] (fermatNumber n 0 3))
  ([n p Fp]
   (cond
     (== n p) Fp
     :else (recur n (inc p) (bigint (+ (* (- Fp 1) (- Fp 1)) 1)) )
     )
   ))

(defn fibonacci
  ([n] fibonacci (fibonacci n 2 1 1))
   ([n,p,fb,f0]
    (cond
      (< n p) (bigint 1)
      (== n p) (bigint fb)
      :else (recur n (inc p) (bigint (+ fb f0)) (bigint fb) )
      )
    )
  )

(defn fibonacci_truth
  ([n] (== (+ (* (fibonacci n) (fibonacci n))
              (* (fibonacci (+ n 1)) (fibonacci (+ n 1))) )
           (fibonacci (+ (* 2 n) 1)))  ) )

(defn getFirst
         [f collection]
  (first (filter f collection)))

(comment
(fibonacci 19)
(fibonacci 9)
(fibonacci 10)
(+ (math/pow 55 2) (math/pow 34 2 ))
(fibonacci_truth 19)
(fermatNumber 0)
(isItPrime (fermatNumber 0))
(fermatNumber 1)
(isItPrime (fermatNumber 1))
(fermatNumber 2)
(isItPrime (fermatNumber 2))
(fermatNumber 3)
(isItPrime (fermatNumber 3))
(fermatNumber 4)
(isItPrime (fermatNumber 4))
(fermatNumber 5) ;4294967297
(isItPrime (fermatNumber 5))

;(fermatNumber 6) ;18446744073709551617
;(isItPrime (fermatNumber 6))
;(fermatNumber 7)
;(isItPrime (fermatNumber 7))

(fact 5)

(fermatNumber 2)
;(fact (bigint 24))
(isItPrime (bigint 3) )
(isItPrime 1)
(isItPrime 2)
(isItPrime 3)
(isItPrime 4)
(isItPrime 5)
(isItPrime 6)
(isItPrime 7)
(isItPrime 9)
(isItPrime 10)
(isItPrime 11)
(isItPrime 13)
(isItPrime 96730)
(isItPrime 96731)
(isItPrime 96732)
(isItPrime 96796)
(isItPrime 96797)
(isItPrime 96798)
(isItPrime 96799)
(isItPrime 96800)
                                        ; 96703	96731	96737 are primes
                                        ; 96797	96799	96821 and these
;
; >>> impq.isItPrime(96739) True >>> impq.isItPrime(96740) False >>> impq.isItPrime(96738) False  
(isItPrime 96738)        ; is not prime  
(isItPrime 96739)        ; is prime
(isItPrime 96740)        ; is not prime
(isItPrime 10006659821)  ; is prime
(isItPrime 10006659823)  ; is prime
(isItPrime 10006660007)  ; is prime
(isItPrime 10006660001)  ; is not prime
;(isItPrime (bigint 1000000000000066600000000000001))
;;
[1 2 (math/log 3)]
) ; COMMENTS!

(defn -main
  "I am documentiation for the funtion and don't contain a whole lot ... yet. can be executed via cli as $ lein run 13 "
  [& args]
  (println (first args) )
  (println (if (isItPrime (bigint (first args)) )
             "is prime"
             "is not prime") )
  )

