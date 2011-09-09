(ns CljPerceptron.learning)
(use 'CljPerceptron.perceptron)

(defn train-perceptron [p learning-set learning-rate]
  (if (empty? learning-set)
    p
  (let 
      [weights (get (meta p) :weights)
       input (first (first learning-set))
       expected-out (second (first learning-set))
       actual-out (p input)
       error (- actual-out expected-out )
       new-weights (map (fn [w,x] (do 
                                    ;(println w) 
                                    ;(println x) 
                                    (+ w (* learning-rate error x)))) weights input)
       new-p (make-perceptron (get (meta p) :bias) new-weights (get (meta p) :threshold))]
    (do
      ;(println error)
      ;(println new-weights)
    (recur new-p (rest learning-set) learning-rate)))))

