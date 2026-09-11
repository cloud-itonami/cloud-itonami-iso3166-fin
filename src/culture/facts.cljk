(ns culture.facts
  "Country-level regional-culture catalog for Finland (FIN) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"FIN"
   [{:culture/id "fin.dish.karelian-pasty"
     :culture/name "Karelian pasty"
     :culture/name-local "Karjalanpiirakka"
     :culture/country "FIN"
     :culture/kind :dish
     :culture/summary "Traditional Finnish pasty originating from Karelia, with a thin rye crust typically filled with rice or potato; holds EU traditional speciality guaranteed (TSG) status since 2003."
     :culture/url "https://en.wikipedia.org/wiki/Karelian_pasty"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "fin.dish.kalakukko"
     :culture/name "Kalakukko"
     :culture/country "FIN"
     :culture/kind :dish
     :culture/summary "Traditional Finnish savoury pie of fish baked inside rye bread, from the Savonia region and particularly popular in Kuopio; obtained EU TSG status in 2002."
     :culture/url "https://en.wikipedia.org/wiki/Kalakukko"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "fin.dish.mammi"
     :culture/name "Mämmi"
     :culture/country "FIN"
     :culture/kind :dish
     :culture/summary "Traditional Finnish dessert eaten around Easter, part of Finnish culinary tradition dating back centuries."
     :culture/url "https://en.wikipedia.org/wiki/M%C3%A4mmi"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "fin.dish.ruisleipa"
     :culture/name "Ruisleipä"
     :culture/country "FIN"
     :culture/kind :dish
     :culture/summary "Finnish rye bread, the most popular type of bread in Finland, holding the status of national food as determined by a 2017 vote."
     :culture/url "https://en.wikipedia.org/wiki/Ruisleip%C3%A4"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "fin.beverage.sima"
     :culture/name "Sima"
     :culture/country "FIN"
     :culture/kind :beverage
     :culture/summary "Finnish fermented low-alcohol drink traditionally made from honey and water, a seasonal drink strongly associated with the Vappu spring festival."
     :culture/url "https://en.wikipedia.org/wiki/Sima_(mead)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "fin.craft.puukko"
     :culture/name "Puukko"
     :culture/country "FIN"
     :culture/kind :craft
     :culture/summary "Small traditional Finnish general-purpose belt knife with a single curved cutting edge, a significant symbol in Finnish national heritage."
     :culture/url "https://en.wikipedia.org/wiki/Puukko"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "fin.festival.vappu"
     :culture/name "Vappu (Walpurgis Night)"
     :culture/name-local "Vappu"
     :culture/country "FIN"
     :culture/kind :festival
     :culture/summary "One of Finland's four major holidays, celebrated 30 April to 1 May with the biggest carnival-style festival in Finland's cities, sima drinking and student cap traditions."
     :culture/url "https://en.wikipedia.org/wiki/Walpurgis_Night"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "fin.heritage.suomenlinna"
     :culture/name "Suomenlinna"
     :culture/country "FIN"
     :culture/kind :heritage
     :culture/summary "Sea fortress composed of eight islands near Helsinki, Finland, a UNESCO World Heritage Site since 1991."
     :culture/url "https://en.wikipedia.org/wiki/Suomenlinna"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

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
      :note (str "cloud-itonami-iso3166-fin culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "FIN"))
                 " FIN entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
