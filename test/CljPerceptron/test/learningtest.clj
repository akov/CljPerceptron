(ns CljPerceptron.test.learningtest
  (:use [CljPerceptron.perceptron])
  (:use [CljPerceptron.network])
  (:use [CljPerceptron.learning])
  (:use [clojure.test])
  (:use [CljPerceptron.util]))
(def err-thresh 0.0000001)

(deftest one-learn-step
  (let [p (make-perceptron 0 [0 0 0] 0.5)
        ls (list (list (list 1 0 0) 1)
                 (list (list 1 0 1) 1)
                 (list (list 1 1 0) 1)
                 (list (list 1 1 1) 0))
        new-p (train-perceptron p ls 0.1)
        new-bias (get (meta p) :bias)
        new-weights (get (meta p) :weights)
        new-thresh (get (meta p) :threshold)]
    ;(println (meta new-p))
    (is (= new-bias 0))
    (map (fn[w1, w2] (is (< (abs (- w1 w2)) err-thresh))) new-weights '(0.3 0.1 0.1))
    (is (= new-thresh 0.5))))
