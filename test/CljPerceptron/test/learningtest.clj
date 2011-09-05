(ns CljPerceptron.test.learningtest
  (:use [CljPerceptron.perceptron])
  (:use [CljPerceptron.network])
  (:use [CljPerceptron.learning])
  (:use [clojure.test]))

(deftest one-learn-step
  (let [p (make-perceptron 0 [0 0 0] 0.5)
        ls (list (list (list 1 0 0) 1)
                 (list (list 1 0 1) 1)
                 (list (list 1 1 0) 1)
                 (list (list 1 1 1) 0))
        new-p (train-perceptron p ls 0.1)]
    (println (meta new-p))
    (is (meta new-p)
        {:bias 0 :weights '(0.3 0.1 0.1) :threshold 0.1})))
