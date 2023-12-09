package fifth;

import java.util.Arrays;
import java.util.List;

public class FirstTask {

    public static void main(String[] args) {
        var input = """
                seeds: 432563865 39236501 1476854973 326201032 1004521373 221995697 2457503679 46909145 603710475 11439698 1242281714 12935671 2569215463 456738587 3859706369 129955069 3210146725 618372750 601583464 1413192
                                
                seed-to-soil map:
                2824905526 2969131334 898611144
                0 322319732 9776277
                379216444 692683038 140400417
                3723516670 1559827635 9493936
                637824014 332096009 211964909
                929691047 1569321571 35824014
                965515061 1605145585 1281263183
                621118546 833083455 16705468
                9776277 0 322319732
                332096009 544060918 47120435
                3733010606 1319171816 134731872
                2329500810 1453903688 72388062
                2401888872 1526291750 33535885
                2246778244 2886408768 82722566
                2435424757 929691047 389480769
                519616861 591181353 101501685
                                
                soil-to-fertilizer map:
                2819195624 2690204780 252557843
                1098298904 1339121422 10546957
                499510245 852292683 97183057
                4225167944 2372810194 69799352
                887408376 1808006977 56225538
                3071753467 4058417302 4632491
                2455749676 3452467754 363445948
                2243979338 3846646964 211770338
                3076385958 4063049793 231917503
                3860856553 2269547568 103262626
                943633914 21067281 39980869
                1388096097 1584043708 223963269
                3493291351 2442609546 247595234
                1801722612 949475740 41203502
                264653767 678191385 102026845
                3740886585 2942762623 89236706
                1152866424 310132079 235229673
                3830123291 3815913702 30733262
                249083929 1568473870 15569838
                1612059366 1506703078 61770792
                366680612 545361752 132829633
                1108845861 1992124969 44020563
                596693302 1048406348 290715074
                3467723121 2243979338 25568230
                1879110833 1349668379 157034699
                1858043552 0 21067281
                3308303461 3293048094 159419660
                3964119179 3031999329 261048765
                983614783 780218230 72074453
                1055689236 1005796680 42609668
                1673830158 1864232515 127892454
                1842926114 990679242 15117438
                0 61048150 249083929
                                
                fertilizer-to-water map:
                0 434502471 470583313
                1739362496 1919893972 48874906
                2735409723 1968768878 16148586
                3324522082 1858151799 61742173
                4137416965 1984917464 25502361
                470583313 2971682591 186824423
                2751558309 2532295557 111781313
                3664705516 1340674299 435773845
                1851374390 3898529330 80666020
                857422234 2010419825 207606184
                1788237402 2418040507 63136988
                1065028418 0 434502471
                1499530889 2481177495 4578648
                4162919326 2916167530 55515061
                1670138099 3158507014 69224397
                3386264255 905085784 278441261
                2496170686 3979195350 239239037
                4100479361 2879229926 36937604
                1504109537 3227731411 166028562
                657407736 2218026009 200014498
                2909879036 3393759973 257495792
                1932040410 2644076870 235153056
                2167193466 3651255765 247273565
                2863339622 2485756143 46539414
                3167374828 1183527045 157147254
                2414467031 1776448144 81703655
                                
                water-to-light map:
                894548549 593866955 6252040
                3168871398 327816880 11668092
                3549766643 2935057349 16258370
                1070236274 1304104659 106353135
                900800589 723222576 35881223
                2175309976 2744985745 82677694
                3969615926 3819543751 36919401
                4086160816 4015453657 208806480
                0 360262147 233604808
                3566025013 1514177176 87956572
                3440195928 1874477761 44575925
                1851853101 948479332 113304167
                2969520516 3389635913 199350882
                1504406289 1061783499 137386237
                623007058 1630426233 244051528
                1749186436 620555911 102666665
                2154532801 339484972 20777175
                1965157268 759103799 189375533
                4007153882 3758595179 60948572
                3180539490 2951315719 231363953
                233604808 1471149229 43027947
                276632755 1919053686 114911374
                1176589409 0 327816880
                867058586 1410457794 27489963
                391544129 1199169736 4581933
                603082303 600118995 19924755
                4068102454 4276290379 18058362
                3810625421 3856463152 158990505
                2969008355 620043750 512161
                3758595179 4224260137 52030242
                396126062 3182679672 206956241
                4006535327 4294348741 618555
                3484771853 3588986795 64994790
                2257987670 2033965060 711020685
                1641792526 2827663439 107393910
                3411903443 1602133748 28292485
                1037034802 1437947757 33201472
                936681812 1203751669 100352990
                                
                light-to-temperature map:
                1726863959 864157287 834947717
                263199301 190436173 53620398
                1393417259 1699105004 333446700
                2783912856 244056571 155961192
                2939874048 400017763 299945457
                671449939 2517852185 721967320
                2561811676 2295751005 222101180
                0 2032551704 263199301
                481013766 0 190436173
                316819699 699963220 164194067
                                
                temperature-to-humidity map:
                603287260 3766826980 8741130
                572607531 3684982838 30679729
                2084038135 1101548002 100083930
                655933651 3228345771 56278566
                1881393627 553997241 168332584
                553997241 2882185871 18610290
                627184746 1072799097 28748905
                612028390 3397056204 15156356
                1693489030 1430646491 187904597
                3039118107 1734352525 2023479
                220345266 0 43042720
                840454312 3775568110 147781659
                2184122065 3715662567 51164413
                317040325 171240045 2422893
                3245373536 4158663426 136303870
                145773749 385599932 74571517
                0 43042720 128197325
                1490020808 4094893831 63769595
                319463218 173662938 140708231
                712212217 1821839294 128242095
                128197325 314371169 17576424
                2474405575 3923349769 171544062
                2352890439 3105028111 121515136
                3467140696 3318936261 78119943
                2235286478 3226543247 1802524
                4084196651 722329825 210770645
                1553790403 933100470 139698627
                1261006249 1201631932 229014559
                263387986 331947593 53652339
                3137034338 2900796161 108339198
                988235971 3412212560 272770278
                2237089002 1618551088 115801437
                3381677406 1736376004 85463290
                3545260639 1950081389 538936012
                2049726211 3284624337 34311924
                2645949637 2489017401 393168470
                3041141586 3009135359 95892752
                                
                humidity-to-location map:
                596652260 530461632 95173962
                3845096173 1731990943 158117085
                2243878974 1890108028 393769632
                0 625635594 63651375
                1920725725 753532949 155684321
                63651375 329652856 200808776
                264460151 0 60175490
                1381444473 2283877660 346420873
                4003213258 3594530530 47694548
                548036821 60175490 46076186
                4100105147 1678246429 53744514
                2637648606 3642225078 292412911
                324635641 106251676 223401180
                4050907806 3545333189 49197341
                4153849661 909217270 141117635
                3455132509 3477799963 67533226
                594113007 689286969 2539253
                2930061517 2630298533 525070992
                753532949 1050334905 627911524
                3522665735 3155369525 322430438
                2076410046 3934637989 167468928
                1727865346 4102106917 192860379""";

        try {
            var groups = input.split("\n\n");

            var seeds = Arrays.stream(groups[0].substring(7).split(" "))
                    .map(Long::parseLong)
                    .toList();

            var seedToSoilMap = getList(groups, 1);
            var soilToFertilizerMap = getList(groups, 2);
            var fertilizerToWaterMap = getList(groups, 3);
            var waterToLightMap = getList(groups, 4);
            var lightToTemperatureMap = getList(groups, 5);
            var temperatureToHumidityMap = getList(groups, 6);
            var humidityToLocationMap = getList(groups, 7);

            var mappedToSoil = map(seeds, seedToSoilMap);
            var mappedToFertilizer = map(mappedToSoil, soilToFertilizerMap);
            var mappedToWater = map(mappedToFertilizer, fertilizerToWaterMap);
            var mappedToLight = map(mappedToWater, waterToLightMap);
            var mappedToTemperature = map(mappedToLight, lightToTemperatureMap);
            var mappedToHumidity = map(mappedToTemperature, temperatureToHumidityMap);
            var mappedToLocation = map(mappedToHumidity, humidityToLocationMap);

            var lowestLocation = mappedToLocation.stream().min(Long::compareTo).get();

            System.out.println(lowestLocation);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static List<Long> map(List<Long> seeds, List<List<Long>> seedMap) {
        return seeds.stream()
                .map(seed -> {
                    for (var map : seedMap) {
                        var  mapTo = map.get(0);
                        var start = map.get(1);
                        var  range = map.get(2);

                        if (seed >= start && seed < start + range) {
                            var diff = seed - start;
                            return mapTo + diff;
                        }
                    }
                    return seed;
                })
                .toList();
    }

    private static List<List<Long>> getList(String[] groups, int x) {
        return Arrays.stream(groups[x].substring(groups[x].indexOf("\n") + 1)
                        .split("\n"))
                .map(s -> Arrays.stream(s.split(" ")).map(Long::parseLong).toList())
                .toList();
    }
}
