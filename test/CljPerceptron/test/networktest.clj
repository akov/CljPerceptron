(ns CljPerceptron.test.networktest
  (:use [CljPerceptron.perceptron])
  (:use [CljPerceptron.network])
  (:use [clojure.test]))

;link two nand's together in a network and see if they work as expected 
(deftest nand-network-test
  (let [nand1 (make-perceptron 0 [0.8 -0.2 -0.1] 0.5)
        nand2 (make-perceptron 0 [0.8 -0.2 -0.1] 0.5)

        net {`nand2 '(1 `nand1 1)
             `nand1 '(1 1 1)}]
    (is (eval-perceptron nand1 net) 0)
    (is (eval-perceptron nand2 net) 0))
         
   (let [nand1 (make-perceptron 0 [0.8 -0.2 -0.1] 0.5)
        nand2 (make-perceptron 0 [0.8 -0.2 -0.1] 0.5)

        net {`nand2 '(1 `nand1 1)
             `nand1 '(1 1 0)}]
    (is (eval-perceptron nand1 net) 1)
    (is (eval-perceptron nand2 net) 0)))

