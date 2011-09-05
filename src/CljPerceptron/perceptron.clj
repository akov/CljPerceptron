(ns CljPerceptron.perceptron)
(use 'CljPerceptron.util)

(def err-margin 0.000001)

(defn make-perceptron [bias weights threshold]
"produces a perceptron which is a function that takes a vector of input values
and returns 1 or 0
it is created with a bias, a series of weights for its inputs, and an activation threshold"
  (with-meta 
    (fn perceptron [x]
      (if
        (< (abs (- (+ (dot-product weights x) bias) threshold)) err-margin)
        1
        0))
    {:bias bias
     :weights weights
     :threshold threshold}))


