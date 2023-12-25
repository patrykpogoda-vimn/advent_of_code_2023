package advent_2023.twentyfive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FirstTask {

    record Connection(String from, String to) {}

    public static void main(String[] args) throws InterruptedException {
        var input = """
                vmq: rcq qvj bpj
                fgc: gph
                cgg: jnf fmh pbf tmm qml
                ghp: pvl
                fbh: zcx
                xmk: vvb fgk prt dkd qcc hqj
                jkl: zvz
                zsx: msc jpr qmq
                cdf: qlc mtk bnq
                knq: qpb
                dhd: php
                snc: jgz vnf cxd
                tgf: jnh chp
                snt: pvb nlp fhl
                flp: kcj
                xvr: mcl xjs dfg
                xsx: kxk dxr jxx std xdz
                cnf: fbh bpq bnq jvb
                xtt: pjm klj
                kpf: rlp mrn
                vns: fjp ksm
                ztj: jpf dhd nkr
                tlr: sth jdj njk qcc
                qkx: cvn
                njx: zzm
                mnd: lkx hnm qrg
                qtf: jdn
                zdq: ffd gxc tcr
                nqb: smc hnm sbr
                mzf: qsr
                qnl: tdl
                nhg: rhp lxz ldd xqx
                jqn: mmv
                qtv: bhp hpt sth dcl
                mtk: ctm
                nkq: dhx nzh hmx tct grr
                nms: qls jpn ljj
                pvj: dhx smc
                flm: lzm mrs
                plv: lsd kxl hpt
                qjf: cpd qml
                zkl: snq
                gjr: zkb hpz csr mfr
                zfg: lcc
                xls: pvd qpb vlm
                gbz: xnq
                gnn: rlp tdf dlx
                zjp: vqx lcc fzb vls
                fhc: hpl nvq
                lhj: cmd bkz
                jkb: dsk klh qbc zkr
                jvm: zrd rtb lnv xjr qgj
                zpd: znz zqz pzf xll dgb
                vqv: cbc pbp skx
                zrv: xnt hlc gfp
                kvh: czb zzf pmn
                gcm: nlp mgz mlt dzl
                gvk: xmv xfc rzh pfl lzn
                bhg: mrd cms hzx kjq
                fzq: msj qxz ppf rtj lzh
                hrm: kkk qqx mjg phg
                rrc: qtf
                jqc: ckk qzf mdv
                pfk: tqs gmv tjz lzq mdr gzh
                vfq: zfg jbg xss
                tvz: kps htx rtb
                dxv: cxq mrz svs hbb
                bbk: shp jlg tvs tcj
                hsl: qsk grr kmg vdn
                blb: dph fvk bfv
                qtz: flz hbc tzd std hqp
                rkd: rrd pjm clr
                trm: czb mht
                gfh: mhs tsp dkn
                jks: lsd dct trk pqt
                tvp: jlg zch ggg
                pdj: pnz nzm
                rbg: gkq
                zbx: pxn mdk fxz
                vgx: ctq
                skc: mgt rdf
                rlr: frk msp mtc tjs
                zpn: hpl gjk vvb
                hft: czb
                znd: pvd knn nbg
                zcx: mzq jph
                mjg: cnx
                lxf: tvb sqg zph
                drs: fvm
                nrc: psv rpq
                dhk: bzc
                dcq: pfx mbg
                ktq: pdj hrv php
                kkj: nts dvr
                xfl: nxj vcb zld
                fnn: pnk
                cgp: hxk qjz bjd
                lmf: fdx
                mcq: qkl xhg hqp
                hjc: lrf jjp
                rzv: ngr gxh
                sfn: ltb qgj mtm cdd kpg
                ftj: szr
                cph: zdf qbz
                tzg: jbj jpx dqz kgp jgx lzn
                xql: kpq
                cvd: mjk rtn ssn khq
                bcm: klj
                pkt: crz spn
                tlc: vkl bjt
                fdg: zqm mtq
                pcg: srb
                mcz: pxn
                vks: qxf kpq
                jmh: qjr rpg
                pkm: cxq
                bnq: xnq ddd
                jvb: srq jgc
                jzr: jzm rqz zrg vtj zqn
                qbn: jpz nbn qkx
                kvp: hzx fgv tct
                qjm: xqm djj tlv bnf
                rld: fcc lcv nnl hlt zsp
                rsm: lmh czt
                gxz: tpn mrs gvn
                qrj: djg dss
                rfb: pvl bpq
                sjg: rns
                xmp: cbz fkx sqr
                nzq: dcm tcr gvv
                ksz: bxq ksm
                sbs: rck dzj mpf
                ndp: dhk lsd rnf lrf
                hnt: mhz jrz zgc bpq cgv
                xqx: dlx
                ndq: rbt
                mdh: tlr
                dqn: xgn hkr sbs pjg
                hxb: dhk qcc qbz
                lrr: bkz kgc
                fds: nbg
                vfn: lmk pzn hkn ctj
                vdn: sxb
                xlv: ltr mkm
                zbp: knq qpj
                lcx: mjg njx bzq tjz
                jst: czq gqx cqm nbv
                grf: fbv
                xjv: vfx txr pcm
                svr: hgv ngh lrm gdv
                fpc: qcl
                gcv: xtt dsr mcj tvh gxs
                zsp: xhg
                tdf: nxj
                dcm: fdx
                bhr: ths
                qlc: bjt gcr nkz
                rpp: lvd tcr kpf ktc
                vlg: gmt lfk nnt kck
                xmj: scs vnq
                qxx: jlv jpq
                mgl: rlp
                zhs: pmf qvj
                chm: sxc jvz mmv
                nfg: bzc pkf gmb
                djg: rfl jgl dgd ghh
                jxx: fbc kmf qdp vpc
                lfz: czh
                nzn: tjx pnk jgt tvz
                cbj: dmt zpn pnz czz
                xll: mtq vcb lrr
                ptn: kgv zqc dvq hbc
                jrk: ghx ffm vld htx
                hqc: dbv gqt bgk
                qkl: hqp
                vls: kth
                lpz: fps pbp mrk
                fqd: bhr hjc mcq trm
                rzl: tsc dkk zqs
                plh: ckb rrd tzq lpv ddj
                jbj: zrb jpn sxb
                dsr: msj bdx
                lzt: hvx rgj ggn
                fjp: gkd
                bnl: ztk dvr
                pls: rtj
                xxh: dvv dkp zqq
                kdk: xcz xqx vdz rgq
                jrp: fvm fhc
                jlv: jbg lpn
                bsf: kgc
                nqd: mdr xtq mrd dcq
                gpj: xnq qds ddv
                dmv: dsj
                tjt: qbz txh
                gjt: bth krv tzv smd
                vlm: knf rdf kkk
                bhs: ltt cnl lzn zkq
                xmv: zjp nsp
                lln: mdg zbx dzr cdm
                rxl: dph mtx bpj pnz
                gvs: ncd chx njx zmj lzm
                rtg: xdh fvg
                zjt: kxk bdx
                tkf: jlm mdk hpd btf
                bbs: rxq cdm lpv zbs btf
                jzz: grs bkm
                pjt: rrd qqq vxq sll
                lbg: ssl rck vbl
                jds: gxc zlf
                plg: hmx fqj rfl
                lpq: gpj fpq nqs nzq mxb
                jzc: jpr pls
                zqz: tlc jqn
                jsg: jkg xgr tct
                dss: xdh bzq
                msj: znl qsn
                zkv: vnt llm bxq tvb
                kdz: xzl vrt nbv
                mhv: zjt tzd pqv dxg
                vll: jqn mzq lrh
                pbm: vll cdh ncd tct
                zrb: pzb mrl mrj
                gkk: vqj hjh xrl khg rrh
                cdm: trk
                dvr: gzh
                css: vfg sqq gfp xcz mzf kmr
                tjj: pjg
                zgj: bqb trm fbl bkm vtb
                vrh: gqd rns lmh
                rcm: zjt rck cqk
                mlg: ljn bhp flp sxs
                sll: kck djk kzm
                zch: bcx kgc
                hqr: slv gqs hgv llm
                rpg: dsk vkd dns
                gqt: hdr fhp rtn tdl
                czt: kgj jgl
                lsg: nbs cdm czh rxq
                cdx: chp
                cdv: phf qxq nlp
                txx: pfl mst
                ntb: smd xhg nnd
                txg: lqb lsh
                lqr: cdx thr nzt xsn
                vxq: nkr bzt
                nkf: fhc hnf
                hqj: rbg kxk fpc
                bsq: xls dzl sbp
                jvz: ltt
                dmt: hvx
                nbr: mfr qpx pgl qlc
                tgh: zdr qqm njk jqf
                gmt: jqf kdc rcm xhm bcm
                kvt: dgf mdh gdh zvz psh
                smj: rjs mtm zxm
                tbl: hck bgr grr
                mnv: blf
                pph: nkr fxm
                rhv: hrj
                jrm: gtn bzt
                lff: vpp ndq slv
                hlj: dqj xnl pzf dhx kpq
                fcg: dzr ngr mnn sbc
                krp: ctl rfb
                vzm: jbx jqr
                hpz: mrz tbx
                ccv: phg scs
                rjs: fqz
                rrd: qcj
                zqq: dnb
                fvk: mpf
                tps: fxn
                jnh: ptf psc
                mbn: nbs pjg gxh
                fxg: znb lbg mnv rbt vlq
                mzt: dmh hsm fkr
                qth: frk nbk sqt cbc
                ldh: lnd psc ffx
                sjl: xqm ckk
                szt: nqb gct snt ngx
                lvt: ldq bld mlp rgl
                czz: tlr xgl
                cnh: tjx
                zkb: csn
                ltt: mrl
                fgv: crz cdx mhz
                jmd: xxn tvb hbh vfx
                fvl: ddc lbn thr pvd
                ddp: mdh jnf lgg ssl
                tct: mjp
                qlv: bxq znl txq lcv
                hnd: htg hzh bsq
                ckm: mgn nts dgd
                dtr: knq chx dzt lxv
                vpc: txr
                qml: kxl mhf
                hsr: pcp qtk
                nfn: bzq gsf nlp
                gjx: jgx
                jpr: fnk hkq
                nlh: flz qqm mvx sjc
                dzl: bvx fdx
                rhn: bmt zpm gqd vcb
                rlk: djk nbs mcz gjk
                mkg: ghm bcz
                pvd: nsp tcc
                vkf: cjl pdr kzg dbv csp
                mpz: ffl rrc hdr blf
                pkp: mgt vcf dqj ddd
                dgv: vzr bfn hkq xgl qhz sfl
                khq: zdr gkd
                lnv: qsr dhj mtk
                xkj: gfx sbm
                vlh: rfl ghp bkz
                flc: hrj mmv jgz mgl
                kcr: tjd
                fxq: bjj mgt chm xjr
                tbx: qcr kkj
                rsl: jqc phn qsj sjs cgp xlz
                qcj: llp qzf
                phg: vcf rfb
                btt: tjc
                hdt: sqz pqv xbg
                qqq: gbm ljn dxg mlp vvz
                fcv: dbv qgv tjd
                grs: xqm fkr
                xxn: qhl ntf
                gcr: fvg
                pkl: xzg jzr fgk mlk
                jqj: bjj
                phf: lkx nxj tsd
                fzb: hhb bld
                kqv: nxf ssc jjg mcl
                zfh: bjt pxr
                gsf: xkp scs kzs
                dzj: vnt
                xzl: nnp dmh mdg ncq
                zcf: dfr hsm lcr qkx
                jdj: mpf kbl
                msp: mrl
                vck: xzx csp tnj zph
                nnp: hpt nzm
                dfp: vhj rfb plg rrn
                phn: gkd pls
                txq: xqm qhs
                gbf: plv rqz jzz nfg hpd
                zst: hjd ksc hrj zfh hbg
                mdc: jqj ksg mxb vfq
                xbg: gdl tlh hqt rbt
                hbl: fpv nlb bzx vns
                nbg: sqr
                dsc: jdn pkf tnj plr
                lgg: qkx
                tcj: dmk zqq jgl
                lpv: php
                gtk: czh qpr bjr gtn
                dpj: mht cmk
                mqh: sxf zgb zjk tgb
                fkg: htt fpv vvz tff lsf
                mtx: tlh zzf jqr
                xfz: gzf zbx cks blb
                lzc: pvl jpq qxx qds
                qjc: jbx jjp jnq qtk jpf
                kzg: hnf kxh mzp
                pvv: gzn qvm kcj
                csr: fqz fnh
                xlm: qhs mkg clc qll qcq
                dff: dsr sqg zmr
                fjb: cjl pdh kzb
                knv: grf jvz zpm tbx
                lmh: lvd
                bzt: mhf zhn qzc
                znb: ctj sjl
                gqb: kfp rhj pvv
                ddj: jqf
                jdp: hnq ptm qbn fnk
                gps: trz bcx
                xjs: plg svs
                gzf: sxv qtf
                pjm: qzc
                ngr: gmh
                bvg: kcr fnk xvs nnl
                dph: bth
                prt: sjs xqm fxn
                htg: knf qxq jph
                rxn: phg tcf gvv jgz
                dpr: mnf cdv gxc sxc
                qcq: txh
                jnq: fcc
                nzx: lxz
                lrt: hbb fgv sxf
                mph: nsp thr rrn
                lbp: mht
                ddc: dhj fvg
                kbz: hsm ngr
                jpl: sqz lsd kdc qlz
                ltb: tlf zgc
                jlm: jzf jzz lsf kfp sqg
                rfq: mcb
                pzd: jnf xjz
                kxh: htt hkr ctt ctj vpp
                dtm: rsm thl kjq hgl dfv
                pvc: bxd ptt ptf fbh qcr
                psh: msn xhx
                pdh: rxv
                chq: bfv fjh plr qmq
                qpr: zxx
                ghm: rbg
                vcf: zkb nbg
                tft: zxm ghh dmk
                dkd: pdh gkh mjk pzd
                qls: sqt dcg jqn
                xss: xmv mrz rfl zgb
                nhq: ktc klf zdq fst
                dtf: lcc mkl
                gbc: hpv
                bts: jds
                tkd: pgl gps vnq
                jzf: hdt qqq qqk
                njj: hmx sqr vlh
                cqs: zdr gvx qxb tps
                gvx: mzv hkr fxz
                hng: qrn rbg xlm
                rns: cmd
                ghj: dhx pvj fhl jzj njd
                sbp: scs qqx
                cpj: nxj srq
                bbj: mhz dhx gfp
                hkx: xmp tzk qdf fqj
                fht: ffd
                srs: btl
                fmm: gjx mcb qkg ftj
                jfl: qxz cvn
                fck: nbk mlt zjj
                nkr: blf ssl xzg
                zkc: zdv
                vvz: fpc
                thl: njx
                tcb: rdf bcx
                hhr: smd kcs vpp xgn
                kjq: rzh
                xcz: rnh gmv
                mhs: bjt xjr vgx
                rpj: mrn pnk mqq gvf
                zbr: mmv rrg vsx rhb rnh
                srq: ftj
                mfn: lmk nkf qsj rzl
                qrr: bqt dfq dmv
                ssl: bjp
                tvh: rjq lmk
                pjv: vlq kbh kbz bnf
                dzr: qpr
                tzq: fnk svt cnj
                jxp: sfj sph jqn ldd
                pzn: csp mcj bcz
                hfh: ndg nrc khm qlc
                nhp: xmj qxf lhj hbg
                qvm: pjm qtk qrn fgk
                nnt: xjg cnj mvv qcq jrp
                bhk: hhv hgp sbp rfq
                chz: mtk mgt dbp mrk njj
                mdk: svt
                vmb: nxf txg crn qfs
                qfs: gjs vsv
                ffl: ndq
                nbs: kbl ctf
                zdr: fgk
                drg: qmq
                nqs: ffm htq
                vxc: cnl rgl ffm
                qjr: xhx
                pjc: zqq pcg lpn qrg
                jxl: hbb
                mnm: xzg btt qcq sqz
                mzv: bjd
                cdh: gbc lrh
                fqx: zpm
                kdc: jbx ckb
                dfg: mrl kpq
                bhl: pkf qhs
                gqd: mrz ffd
                xlz: jnf
                mcj: bhp vrt bzc
                sdf: smj ddd dqz xql khm bvx
                dgf: jqr vxq hrv
                lzd: bmq glh hpz hlc
                bbt: xqx mmv
                lpx: bpg rsc mtl lzq
                crn: ddv tll znq
                bgt: bth qcc php lff
                ngh: mjk dzj zdf
                ppr: cnh mtq xcn plg
                jcb: kpd qcj xgl
                tsd: jbg pvl xkp
                qxb: qgf dsj mkc
                brt: vld vkl dgb
                gvn: sph rht
                mtt: tvp ddc tlz czf
                mkc: krv
                qqk: pvv rvq
                ddx: dzj lsj rvq bjr
                sfd: fzv hbc rxv mjk tjc
                rzq: lpz pkp gps kgp
                ptf: qcr
                qns: hgl dtk bjj
                fvm: pxc ndq vlq bjp
                jlr: gqx kdz btt drg
                pgj: dsk hjv mcz gtn
                bgf: nxf rpq zgb
                jnl: zjj rjs lbn pfx nxc
                bns: dmv
                fpt: kpt vmz rrg qmh bbj
                pxq: cdx tsd dgd
                jpn: lzn
                xnt: qpj
                kpt: ghx jkg
                kgt: bnl qfs ptt pvj gzh
                jpq: rnh zkl
                jmm: tjs nbg jgl clx
                mbk: gtn mzg czp jlr
                mmv: pxr
                vtn: fcv qcc nnp
                clc: gkd lfz ctt
                mkl: gbz
                kqb: kxl kzm lmk
                lrj: tbh psh hng nnk
                rsc: vfg bgg
                sfp: ljj sxc tbl dcm gbc
                gvv: srb
                hzq: lcv nnd djj cbl
                qrg: snq
                mvv: sbd lbp
                kck: xjz
                bxf: ljn ghm
                srv: cks zdf
                kkg: jdn pdr kxl
                mmx: zkq thl xql pkt
                vrm: lfq tsj xvs
                mhb: pzd cnj hlk pcp fmh ncc
                zgb: tgb
                zld: kgc dtf
                lvb: fbv sqr kbx dcq
                bsl: mbg mdz mkm
                lsh: bld vkl
                xgr: zlh sxb rtg
                tsh: dlj mnv gcv nhv ctf
                lnp: vtn xnf gcj hpd
                rcq: txr rbt
                jgc: zqm fpf tlf sqr
                czf: ghh ssc
                tzv: dhk pcm dnf
                bxd: gbk zjj cqd srp srb
                hkj: llp kcj djp lgg msc gkq
                bpg: dmk
                nhv: ctj
                mnn: llm
                gjk: cvr czh
                vzg: rld bhl tzd kmf
                rqz: ddp jlt rnf
                vkd: hgv nvq
                bkt: nkk vpp
                cdd: hzh
                vmz: vgx xcn kmg
                rmp: dsx tjc pxc dxg
                mdr: pxr rtr
                psv: fvg
                sxv: sfl sqz
                rtb: dgb sbm
                nqm: sqt
                gvf: tcf cbx skc kgp jvh gqd
                fxp: tzd dzp dsr fzv
                ffc: sfl krv sjs rbg
                slp: ppb zgc ctl
                kbx: rht bbt mtc
                ptm: hjv mnn gxh tdl
                xsn: dnb jcz
                bkm: kcs
                xqd: hmd xjv tps
                znz: vks cgv
                bct: dkd zvz zgg bfn
                xcn: gmv
                dcl: qkx gdh bqb
                pqv: kxn zdv bth cpd
                jbt: jkl mcj qgv
                tlh: bdx
                cbt: vdn jgx bnl
                tkh: xlk znj rjq hlf psh
                mtq: jrz
                tpz: mlt jgl jcz jds
                szh: cxd jqn xmj
                qxq: qsk
                qrk: zvb zkc ngr rrd
                glb: qds csr hpv
                kml: rtg mfr vks cdh
                ffp: sqt
                dql: rht vxc vvp jds
                qsn: drg zkc qzc
                knn: dsl
                llg: njb rhj fnk klj
                xnp: ctq jlg fkv
                fxz: qhs
                ktg: glb fnn zvt
                rgq: qxx zkq mgn ggv
                dnb: tvp kkb lkx fds
                vdz: nzx fck bjj npx
                fxm: rxv dfq pmj
                chp: fpq
                fpv: hft
                vhj: mtc bpq hrj
                lfq: xzx gmb jpr
                czq: prd zph dqk
                ppf: srs zmr cph
                nvq: ffl
                hrv: zmr
                kjb: hph cdv sqq fct
                vvp: mrd vnf
                vtm: bzq lsh vxc pzb
                khx: vls vgx dgd jsg
                jph: qpj
                hxz: pcg mgl gct
                mfr: pfl
                dxp: dmv ffl
                rpq: qpj
                hmd: txr
                rhf: vrt dxr xlz cvn
                ssc: pvl
                jsn: hqt hjc jmh jnq
                bjj: mgt
                kgj: npx mnf
                nkd: vtx ffp xlv bsl
                xdf: ctq qgj kgp zdq
                ptg: qnl hkq hsm zbx
                trz: kkk
                qxz: lzh vbl
                ngx: hbb kzs
                tsp: trz lmf
                gfx: ghx skl
                tbh: lzh blb
                gqs: nvs pvv gdl
                njd: gcr xlv zzm
                hck: chp cnh
                vgr: pdr qll dnm
                njb: mdh qdv znb ghm
                tcs: qcl tvb xrr mkc
                hnf: qgf
                lkl: hrv czz gsd pph
                prd: hxb
                rfh: klf xpd hjd mgn czf
                jxv: qsk dxv htx
                bdk: knn jkv ffp svs chx
                nxc: cms
                dmm: hgp dcg vcb fpf
                rck: ckk
                kkh: nlf hzx fkv sph
                hhb: rzh jbg
                mjp: rns gvv
                xrr: nnd sfl bjd
                ffg: rtj ktj qbc txq tjt
                xqp: hft mvx cgp ggn gvr
                ktc: lmf
                vfh: vnf mtq
                fps: blp qns mps pxq tcc
                zpb: jqj xcn tqx nrc mjt
                kfp: cph pcp
                djj: dmh
                gsd: kvh blf jqf
                dkr: lxv knq
                ncq: tdl bzx dqk
                bvh: jqf ckb xjz hnq
                qcx: kbz hsr lnf fjh msc
                djk: kpd qgf
                fpk: bcz qmq vkd
                mtl: fgc vrh sfs grr
                mlk: dct nnk sqm
                qtk: dmh
                pkf: blf
                xdh: grr
                mps: kgp hhv
                kzb: dfr kdd cvr rjq qrr
                bbr: mgn pzt lbn mbg
                ths: zqs zmr pxn
                lsj: sth xgn rvq
                bmt: sbm cnh nlp fnn
                bhp: fkr
                hlk: dsc xgn
                zmj: vnf vqx xqx
                fms: pbf cvr mnt dpj bqt
                hms: nbn bxf kpd dff
                zqc: jkl dzr
                bgr: dlx csn
                dlj: ksz pqt
                fst: thr krp jvz rtr
                stl: ffm
                std: bkm bcz
                vnt: qvj
                fmh: kcj
                qnk: xxh cpj pxz zld
                chx: kpg
                xgq: lzt sbd rvq vrm
                qkg: mgl psv mqq
                lhh: hsr hmd lnf jdn
                hlt: mzt hqt gdv
                klh: svt
                gzn: vpc
                fcz: mgz pkm bsq
                lcc: dlx
                gxs: kpk xtt vtj
                frk: czt cqd vls xrl
                bjs: mkc gdh
                mtc: zjj jjg
                lxz: crz
                fzv: zxx
                zkr: xrp bfv vnt
                jpv: qsr mqq zrv qmh
                qjz: sxv pdh vrt
                mzg: bnf jll dct
                hbg: mlp lbn ghh
                bqb: ckk
                ptc: rbg bzx
                jpx: kgj mrj dtk xms
                plj: rbg krv klj
                sfg: ngx ltr fht stc
                gvr: btl qkx zcf
                fkv: tpn
                pzp: ppr vgx xkj bkz
                kbl: msn
                xrl: bts
                lrm: dmv cmk
                frs: mzp tff klj kcj
                sbd: rcq
                kpk: zvz
                ddd: tkd
                bjr: lcv qdv
                ltm: kjj zlh ppb
                jrf: fds
                qbc: pjg
                znl: vnt kbl
                qqx: ztk dgb
                tdr: sbm jpq xgz mst
                rvd: lpn lmh smg bbt
                gbm: hqt pxl
                xms: fqx ztk
                mdv: jll pdj qll
                cpl: fpc sjs mzp pnz
                pgv: jrm bcm gjk gkh
                gnz: hmd qtf jpr lcr lrm
                jgv: mvv bcm drg bjs
                hzh: sph fkv
                rrg: fqx
                qdf: hph mjt rhv znd
                fbc: flz
                mrn: dvr
                cpd: zbx
                cqd: ktc pcg
                mqq: xms
                rdb: zvb drs llm kqb
                lls: ldh kzs fqz fvs
                ncc: ffl xlz dmh
                pmf: gdh zdv blb
                hsv: kjj mst vlh ffh
                bjt: jgx
                fbl: vvz gxh
                vqx: zzm
                cbl: nhv tjd lsd
                stp: krp kpf zxm
                snq: shp
                kct: tcf fvs gfp
                mmz: ksm
                gcj: mnv ctj
                dcg: pnk jlg
                lkx: ztk mhz
                cvr: hdr
                psc: fnh
                lvd: rlp nqm
                trk: lbp
                nlf: lmf nrc
                blp: zrd svs cnx
                tjs: lzm
                pxg: msc pjm nnk
                jvh: cnh mps
                gtn: msn
                qhl: cks sqg kxn
                bkz: mbg
                sqm: hft pcp gmh dns tjd
                tvs: cdh srb pnk
                zgg: fxz sgr dlj
                vhd: dss rdf npx jlv
                gxc: bvx
                bck: gfd qqk hxk lcv
                kpg: rzh tpn
                zph: fjp
                hph: vkl hpz
                jpz: msn zxx ktj
                pvb: cpj cbt jkv
                zrd: gjx xql fht
                ssn: tvh gzf plk
                xlk: mbn frs
                vxj: qlz nkr plj jnq kbh
                vch: qvq jsb qpb
                fct: dkp rgl pkm
                jdf: dbv fqd hcj tff
                dnm: hxb flp mmz
                xzr: qrj bsf ssc
                mcc: tdf tjx nqs vcb
                shr: zbp pxz hnk hlj sjg
                vsv: vnq
                lmv: vsv gfx
                gqx: mdk dpj
                ldq: kkh zkl rtr fth
                mlt: htg rnx
                qsj: kpd srv
                dvq: pcm nvq dsk
                vfx: zvz
                plk: ztj pxc qbc
                msg: kzs zhk pzt mrl
                hkr: zqs dfr
                ccm: fmm shp xcz cdf rsc
                xdp: tjj njk jlt zdv nbn
                mqc: dct vck kbh xxn zdr
                ksg: bts bgg mcl
                rrn: ptf hgp
                tqs: dcm clx kct tpr
                xjr: kmg fkx
                bcz: dhk
                msc: nvs
                ksr: psp lnf rnf
                gvj: hqc gqt fhp dqv pgv
                ggg: lzm
                sqz: gxh
                bnb: zqm ksg rbq ctm
                bgk: lcv dfr
                xgz: lls jvh cbc xjs
                cnj: cvn
                pzf: vld mst
                hvx: nkk
                bmq: fvj bgg tlf
                hgp: tcr knf cnl
                hbc: hqt
                prf: tmm nhv
                hjh: mkl gvn
                qqm: dsj slv hmd
                cks: qdv
                hpl: qtk dmt gfd
                mdz: vqx sxb
                nsb: lpn spn fvg txg khg thl
                pxk: hnf hgc xzl qjf
                sfs: nxc zfh mrj
                kzj: dvv xzr llr tlf
                bth: flp fnk
                xvs: qtv xhm
                plr: vtj
                nbn: pdr
                dhj: pfl mbg
                rtn: llm bpj
                hgl: fpq
                kps: rpq dnb jnh
                rhb: lbn zxm cxd
                hlx: jxl pxz fzb
                lcr: rzv znb
                qhz: ctt gcj sbs
                hmx: ffp
                tzj: fvj gfx hhb
                rrl: tgb xsn jph ksg nqb crz hhb
                dfh: pls lqs kxn xzx dzp
                mrd: skl rlp
                zqj: xvr nqk fbh pxq mcb
                rcp: xnp zld fth zqm
                hcj: bhr srv pph mjk
                pzt: tcb
                zhg: hsm vzm dsr
                cbb: tsp zzm glh
                bhm: zhs gfd lxf xrp
                znj: lgg grs ths
                npx: nxf
                dvv: ctl
                cjl: svt
                rvk: gbz hxz nsp qsr flm
                cbx: hhv
                vcl: qcr glh zgc
                sml: dzt fvg zqq slp
                xdz: sbd dxg zvb
                kgv: txr hvx
                jcv: dhd mhh gzf cmk
                dkn: sjg lrh
                ffm: fpf
                fdr: ljj hck nzx pkm nfn
                tvc: srs dnf bkt bjd jlt
                gmb: sfl zhs
                hnk: pvl dhj
                tzm: zkl pbp tjs xnq
                lpd: jpf pzn zjt
                jsc: tsj phn dqv llp fjb
                fvs: zrs
                sbc: cmk xhx
                pgl: skx
                txh: ktj
                xnf: zhs pqv jll
                mcf: jrm czh qbz
                rgb: jmh mvr ljn mmz bqb bjp
                tjb: lmv gph zpb qkb
                jcz: htq mkl
                rbk: cmk xhx tvk qkl
                pbp: djl
                bln: bts ffm snc szh
                bpx: tgf vch tzj tll zcx
                bgg: mkm
                ffr: shh cbz qrg hcq
                hdr: mkg
                pxn: qvj
                dzp: fxn
                qgj: vnq skx lhj
                qpx: vqv ffx xrl
                khm: ctq
                cdb: rlv tlh ljr vns mpz
                xjg: qzc qgf
                dns: kcr ngr rrc
                vfg: qxq tlc
                dbv: hpl kzm zqn
                fjh: ctf dmt
                dqz: ppb
                zrg: jll trk dzp
                pfx: dbp
                gkf: mrl rtr cbz zfg
                pnf: jfk gqb ffg xmk
                czm: klf czt fdx smj
                jkv: ctl hlc
                czp: qdv xzx prd dxp gzn bcz
                jvp: dqj snq ktg vfh
                clq: qsr mgt rsm lnd
                jnf: bfn
                vrt: tmm
                pmn: cjl
                ldd: nts dqj hjh jrz
                lqs: qxz
                svb: fcg jqr fpv vpp
                hgc: sqz pxn fvk
                jfk: mhh zqc vfx
                gdv: jzc fcc gfd mdk
                hnm: szr
                zqm: mnf
                mrs: cbx kmr
                dzk: qnl qxb zsx xlk
                kgs: tjb khm kth znz
                hgv: mhh
                kpd: bjp
                xtd: drs txr lsd hhs
                bnf: vpc qpr
                kmh: sjg stl jxv fht
                dkk: mpf bjs nvq
                qgm: mcz tzv fpc
                kjj: csr hhv
                vth: fbl pvv zkc pxc rzv kgv
                jrz: mcb
                mjx: tvp bsl dkn lzd
                dqv: kck ddj bxq
                tqt: dqk mht rvq plh
                ncd: bcx qdf
                btf: mmz
                ckj: mzt txr kbh kxn mpf
                ksc: czt jqj mzq
                nkz: fqx
                lgr: jlr lqs zdf qrn rhf
                vsx: tjj rrc
                tlv: kbl lpv srv
                mqp: zhk kct fdg fbv
                htt: mnt ntb
                ncv: bnq mnf xfc txx
                tnj: llp mzv
                cnl: tjz
                qzf: trm
                qll: gkq
                ksm: pmn
                xhm: rck bhl
                gbk: tcc
                bfv: gmh
                dnf: vbl
                hkn: fnk qkl bjd
                clx: fpf
                dgr: xdp bpj jff prd
                gpx: knf gbk cbc grf
                tvk: gkq dhd slv
                hcq: nqm cbz pfx shp
                szz: srs tjj ksr
                sfj: kmr vvp
                jlt: mhf
                zvb: nkk
                hhs: nbv qcl
                sbr: fkx zfg mtq
                dvx: mrk mst hnm gxz
                hlf: qjr mhf pmn
                dfv: cmd jlv ggv
                llr: jgz mkl
                mcl: ljj tjs szr tft dtk
                vpx: ppb rrg txg hkz
                tnt: kpf pkt bsf xfl slp
                clr: xhg zhn
                mdg: qgm ddj qjr ktj
                qpb: kpt jgx qmh gmv
                blm: tlz gvk vnq rlp
                ntf: vlq jfl gkh
                zfl: btf hhs pph mzg dnf
                csn: zrs zpm
                zxm: cxq
                btl: bhl fjp bzc
                jjp: plr zzf
                nzh: mrk rmh khg
                hkz: htx qrj ddv
                tsc: fhp dnm srs
                tsj: mcf txh
                gph: ctq
                mvr: lpd jbt pkf
                ffh: zqz fnn tkd
                zlh: jkg kkb
                qkb: msp rnh zhk
                qvq: xnt kkb
                pvh: vrh qxf dcm kjq
                kxl: fzv gdl
                bhf: hxb zrg dbv hbh
                tkz: cpd tcs ntf ngh bxf
                sxs: bqt btt
                pbd: fds nzq lrh rpq
                dfq: bns
                zvt: rht jgl hlx
                lsf: zdx qmq zqc
                ttn: bbj tgf slp psc
                rtj: nvs
                xkl: dzp qvj bns
                zhk: scs
                mjn: nkk zhg dfq hpt
                zkq: pqf
                zgt: kkg khq sxv hnq
                kts: jkg mjg slp rfq
                vnf: dkr sxb
                zdx: bqt qcl zvz
                ltr: khg fnh
                mhq: stp hnk mkm kkj
                nts: mjt
                gmv: dlx
                rbr: qrj rjs hpv rbq
                vlz: zch ldh dkr jgc
                xrp: jdj mzv
                rbq: cbz
                zhn: smd
                xgl: mhh
                nzm: rnf qbz
                hxk: dmv
                tjz: mgz
                hrj: tcc xnq
                rgj: fgk prf mhh cph
                qgv: fmh php
                lqb: fvs mjt rtb vqj
                crz: xkp
                xnl: bgf rfq tbx
                dzt: jxl hlx
                smg: pgl hnd dtf
                tcf: xkp sqq
                nbz: qjf fvk xsd rxq
                nzg: jrf stc skl dmk
                rmh: cnx sqq
                rlv: znb xjg
                rnc: brt lkx lxz tkd
                mhh: rxv
                mxb: nxj lzq
                shh: dfg zrs smc sxc
                zqn: nnd xkl
                jzm: rrd rjq clr psp
                qmh: tpn
                rdh: llr jpn cms fqj trz stl
                sxf: tlf zkb
                jsb: fqj mnf dvr
                vtk: gjx gcr mcb kmr zbp sfn
                qct: nkf jbx lzh lpv zhn
                kxk: xhg kpk
                lnd: mcl snq
                tsl: zmj vnf lxz lrr
                cfd: bkm gbm pmf dph jcb
                hpd: tff lnf gmn rxq hlk
                rvq: nnk
                ljj: mkm cxq
                rrh: qsk tpr
                zjk: tpr ltt skl
                znq: xpd ltb
                mzp: qsn
                djp: txr dqk cdm
                ggn: ktq jrp qzf
                mvx: sxs
                nzt: xqx rgl vcb nbk
                jhd: crn znq jjg srq
                dmk: gsf
                vtb: rlv gkh vbl
                vfp: mpz tmm mnt tps
                jzj: sfj mdz xmp zrv
                ptt: fmp xdh pqf tgb
                xsd: zxx xjv nvq
                tll: mzf
                dqj: nqm
                nvs: pmj dzj
                mlp: qcr
                mzq: ckm qrg
                cqm: pqt ptm ckb
                dld: pzt hpv klf szr
                fnk: qrn
                nqk: trv dbp nlf
                fth: jvb mnd
                xpz: bjj mph mbg clx
                kcs: mcz
                ljr: vnt trm fcc vbl
                trv: fgc vnq ccv
                gjs: bvx mgz nbk bpg
                dtk: zrs
                pcr: ffd nzx rhv tlz
                nnd: blf
                vsd: xnt xnq kvp mrn dss
                vld: stc
                pqf: vqj djg
                hsk: ffh qvq txx bsf qfs
                gfd: pqt pbf
                dsj: tjc
                tzl: dkr lls cbx fqz
                fmp: gbz mrl qsr
                shm: rhv grf tjx fcz gfh
                nnl: prf sth
                vqj: sqr
                tzk: zzm mrs vcl
                vtj: zqs
                xjk: bkt pmj zmr tjt gzn
                dkl: klh sqm cqk xqd
                gdl: xzg
                kzh: jzc nbv klh tbh
                xfc: ktc fxq nxc
                gct: nbg
                spn: vsv cdd
                kxj: prd bzx lqs lzt
                jff: qll lfz jzf
                fhl: dhj ftj ggg
                zmf: mjp ccm cmd jrf pkp cdd
                fhp: fxn
                vtx: ggg tcb tll dqz
                mxr: rkd fpk zsp vmq
                xhc: nkz sfg xcz fdr
                bfn: xhx lbp
                zbs: fbc jlr lfz
                htq: skx
                vzr: pcm jpf jfl
                kvg: nqb vdn bbr hhv
                nlb: mnn lbg psp
                hjv: dmh zhn
                ffx: xkj knn
                thn: kth msp vfh dvv jkv djl
                tqx: stl glh
                nnk: qnl
                jgt: srp shh lcc
                rhp: rmh mrj fgc
                msz: lzn bgr hlc jxl
                ctt: tzd
                qlz: pjv bnf dxr vgr
                fng: gph ghp fpq rbq ztk
                dkp: dvr qds ltm
                qdp: htx gbc jqj khg
                cms: mjt mkm
                fbv: pxr
                mnl: djj pmn qtk zsp
                pxl: pmj mdv txh
                hzx: ddv
                pzb: rhp srp
                djl: tlz skx pxz
                fvj: ghx pvl
                nbk: ghp
                rhj: nbv ctf
                cxd: kgp
                kch: dxp pzn mdg qkx
                cls: tlc cnx nkz lrt
                hjd: srp gnn hgl
                zlf: htq vdn
                kmf: xqd jbt
                bpj: gkd
                gmn: sbc bns srv njk
                xrn: hnm tzm nxf zjp
                mtm: gct nsp psv
                lrf: csp jkl
                kdd: xjz ntb bhr
                vmj: cbb lmv gbk jvb
                phj: bvx hlx skc mtk
                tkv: bgk sjl vvb llg
                jlg: qxf jjg dbp
                flz: kzm bxf
                sjc: lfq ljn ptc
                dsl: jvh stc zjp
                xpd: zjj fdg
                hbh: sxv vzm
                zdm: bpg pbm ltt nms jrf
                xtq: kth smc csr
                gzh: bld fnh
                krv: zzf
                ctq: lxv
                ggv: rrh cpj
                bmx: lbp vvb kcj dsc
                cqk: drs szz czb
                dsx: hxk ptc bkm
                dxc: pjg kcs jdn hqp kmf
                tjh: ptn fbc fkr jnf
                vmh: flm tdf hzx zlf
                cgv: qlc mzf
                lzq: tqx xgr kkk
                ctm: mst fkx
                ndg: tpr smc kmg
                sfl: bdx
                bht: hkq mvx vsx pxg pdr
                lfk: psp kpk dsr
                vrz: hnq dxr ksz klh
                mnt: pbf
                rnx: kkb lxv ccv
                sgr: gcj gmh kcr
                """;

        var connections = new HashSet<Connection>();
        var uniqueConnections = new ArrayList<Connection>();

        for (var line : input.split("\n")) {
            var parts = line.split(": ");
            var nodeName = parts[0];

            for(var conectedNode : parts[1].split(" ")) {
                uniqueConnections.add(new Connection(nodeName, conectedNode));
                connections.add(new Connection(nodeName, conectedNode));
                connections.add(new Connection(conectedNode, nodeName));
            }
        }

        for (int i = 0; i < uniqueConnections.size(); i++) {
            var connectionToRemoveFirst = uniqueConnections.get(i);
            for (int j = i + 1; j < uniqueConnections.size(); j++) {
                var connectionToRemoveSecond = uniqueConnections.get(j);
                for (int k = j + 1; k < uniqueConnections.size(); k++) {
                    var connectionToRemoveThird = uniqueConnections.get(k);
                    if (connectionToRemoveFirst.equals(connectionToRemoveSecond)
                            || connectionToRemoveFirst.equals(connectionToRemoveThird)
                            || connectionToRemoveSecond.equals(connectionToRemoveThird)) {
                        continue;
                    }

                    var connectionsCopy = new HashSet<>(connections);

                    connectionsCopy.remove(connectionToRemoveFirst);
                    connectionsCopy.remove(connectionToRemoveSecond);
                    connectionsCopy.remove(connectionToRemoveThird);

                    connectionsCopy.remove(new Connection(connectionToRemoveFirst.to, connectionToRemoveFirst.from));
                    connectionsCopy.remove(new Connection(connectionToRemoveSecond.to, connectionToRemoveSecond.from));
                    connectionsCopy.remove(new Connection(connectionToRemoveThird.to, connectionToRemoveThird.from));

                    var count = countGraphs(connectionsCopy);

                    System.out.println("Checked " + connectionToRemoveFirst + " " + connectionToRemoveSecond + " " + connectionToRemoveThird);

                    if (count.size() == 2) {
                        System.out.println("Found it!");
                        System.out.println(count);

                        var list = new ArrayList<>(count);

                        System.out.println(list.get(0).size() * list.get(1).size());
                    }
                }
            }
        }
    }

    private static HashSet<HashSet<String>> countGraphs(HashSet<Connection> connections) {
        var graphs = new HashSet<HashSet<String>>();

        for(var connection : connections) {
            var nodes = Set.of(
                    connection.from,
                    connection.to
            );
            var graph = new HashSet<>(nodes);

            boolean somethingChanged = true;

            while(somethingChanged) {
                somethingChanged = false;

                for(var otherConnection : connections) {
                    if(Set.of(otherConnection.from, otherConnection.to).stream().anyMatch(graph::contains)) {
                        somethingChanged = graph.addAll(Set.of(otherConnection.from, otherConnection.to));
                    }
                }
            }

            for(var otherConnection : connections) {
                if(Set.of(otherConnection.from, otherConnection.to).stream().anyMatch(graph::contains)) {
                    graph.addAll(Set.of(otherConnection.from, otherConnection.to));
                }
            }


            graphs.add(graph);
        }

        return graphs;
    }
}
