package org.ergoplatform.mining.difficulty

import org.ergoplatform.utils.ErgoGenerators
import org.scalatest.prop.{GeneratorDrivenPropertyChecks, PropertyChecks}
import org.scalatest.{Matchers, PropSpec}

class RequiredDifficultySerializerSpecification extends PropSpec
  with PropertyChecks
  with GeneratorDrivenPropertyChecks
  with Matchers
  with ErgoGenerators {


  property("external vectors from BitcoinJ") {
    val longs = Seq(402731232, 402759343, 402836551, 403108008, 410792019, 436591499, 453248203, 471907495, 486604799)
    val calculated: Seq[BigInt] = longs.map(nBits => RequiredDifficultySerializer.decodeCompactBits(nBits))
    val bigInts: Seq[BigInt] = Seq(BigInt("29201223626342991605750065618903157022235193117232857088"),
      BigInt("39718797393257298660757754408019939605415460564426031104"),
      BigInt("68605739707508652902977299640495787127103841947617329152"),
      BigInt("170169861298531990750482624090969781281789404909188153344"),
      BigInt("3045099693687311168583241534842989903432036285033490677760"),
      BigInt("9412783771427520201810837309176674245361798887059324066070528"),
      BigInt("1653206561150525499452195696179626311675293455763937233695932416"),
      BigInt("3447600406241317909690675945127070282093452846402311540118831235072"),
      BigInt("26959535291011309493156476344723991336010898738574164086137773096960"))

    calculated shouldEqual bigInts

  }


}
