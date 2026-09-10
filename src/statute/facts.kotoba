(ns statute.facts
  "General-law compliance catalog for Finland (FIN) -- extends this repo's
  existing `marketentry.facts` (public-procurement market-entry only,
  narrow scope) with a second, orthogonal catalog of statutes a company
  generally must track for compliance. Mirrors
  cloud-itonami-iso3166-jpn/-usa/-esp/-swe/-nor/-dnk's `statute.facts`
  (ADR-2607141700, cloud-itonami-compliance-fact-federation).

  Every entry cites an OFFICIAL finlex.fi (Finland's official, Ministry
  of Justice-owned legal database) English-translation URL -- never
  fabricated. A law not in this table has NO spec-basis, full stop;
  extend `catalog`, do not invent an id/url. finlex.fi rendered directly
  to WebFetch (unlike e.g. fedlex.admin.ch). Every translation page
  itself carries the disclaimer that it is legally binding only in
  Finnish and Swedish -- the English version is an official-source
  reference translation, tagged accordingly.")

(def catalog
  "iso3 -> vector of statute entries."
  {"FIN"
   [{:statute/id "fin.limited-liability-companies-act-2006"
     :statute/title "Limited Liability Companies Act (Osakeyhtiölaki)"
     :statute/jurisdiction "FIN"
     :statute/kind :law
     :statute/law-number "624/2006"
     :statute/url "https://www.finlex.fi/en/legislation/translations/2006/eng/624"
     :statute/url-provenance :official-finlex-reference-translation
     :statute/enacted-date "2006-07-21"
     :statute/retrieved-at "2026-07-15"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "fin.data-protection-act-2018"
     :statute/title "Data Protection Act (Tietosuojalaki)"
     :statute/jurisdiction "FIN"
     :statute/kind :law
     :statute/law-number "1050/2018"
     :statute/url "https://www.finlex.fi/en/legislation/translations/2018/eng/1050"
     :statute/url-provenance :official-finlex-reference-translation
     :statute/enacted-date "2018-12-05"
     :statute/retrieved-at "2026-07-15"
     :statute/topic #{:data-protection :privacy}}
    {:statute/id "fin.employment-contracts-act-2001"
     :statute/title "Employment Contracts Act (Työsopimuslaki)"
     :statute/jurisdiction "FIN"
     :statute/kind :law
     :statute/law-number "55/2001"
     :statute/url "https://www.finlex.fi/en/legislation/translations/2001/eng/55"
     :statute/url-provenance :official-finlex-reference-translation
     :statute/enacted-date "2001-01-26"
     :statute/retrieved-at "2026-07-15"
     :statute/topic #{:labor :employment}}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-fin statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "FIN")) " FIN statutes seeded with an "
                 "official finlex.fi citation. Extend "
                 "`statute.facts/catalog`, never fabricate a law-id or URL.")})))

(defn by-topic [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))
