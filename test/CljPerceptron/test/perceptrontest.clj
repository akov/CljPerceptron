(ns CljPerceptron.test.perceptrontest
  (:use [CljPerceptron.perceptron])
  (:use [clojure.test]))

;test the ability to make a NAND using weights 
;I found on wikipedia
(deftest nand-test
  (let [p (make-perceptron 0 [0.8 -0.2 -0.1] 0.5)]
    (is (p '(1 0 0)) 1)
    (is (p '(1 1 0)) 1)
   (is (p '(1 0 1)) 1)
    (is (p '(1 1 1)) 0)))


