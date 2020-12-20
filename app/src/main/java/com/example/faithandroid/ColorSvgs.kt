import com.sdsmdg.harjot.vectormaster.VectorMasterView

/**
 * This class uses common used functions to color the svg of an avatar
 */
class ColorSvgs {
    companion object {
        /**
         * sets the haircolor of the avatar
         *
         * @param avatarpart is the color the hair is going to be
         * @param vectorMasterViewA is the vector if the Avatar is person 1
         * @param vectorMasterViewB is the vector if the Avatar is person 2
         */
        fun setHair(avatarpart: Int, vectorMasterViewA: VectorMasterView, vectorMasterViewB: VectorMasterView) {
            var path1 = vectorMasterViewA.getPathModelByName("Hair1")
            var path2 = vectorMasterViewA.getPathModelByName("Hair2")
            var path3 = vectorMasterViewB.getPathModelByName("Hair")
            path1.fillColor = avatarpart
            path2.fillColor = avatarpart
            path3.fillColor = avatarpart
            vectorMasterViewA.update()
            vectorMasterViewB.update()
        }

        /**
         * sets the eyecolor of the avatar
         *
         * @param avatarpart is the color the eyes are going to be
         * @param vectorMasterViewA is the vector if the Avatar is person 1
         * @param vectorMasterViewB is the vector if the Avatar is person 2
         */
        fun setEyes(avatarpart: Int, vectorMasterViewA: VectorMasterView, vectorMasterViewB: VectorMasterView) {
            var path1 = vectorMasterViewA.getPathModelByName("Eye1")
            var path2 = vectorMasterViewA.getPathModelByName("Eye2")
            var path3 = vectorMasterViewB.getPathModelByName("Eye1")
            var path4 = vectorMasterViewB.getPathModelByName("Eye2")
            path1.fillColor = avatarpart
            path2.fillColor = avatarpart
            path3.fillColor = avatarpart
            path4.fillColor = avatarpart
            vectorMasterViewA.update()
            vectorMasterViewB.update()
        }

        /**
         * sets the skintone of the avatar
         *
         * @param avatarpart is the color the skin is going to be
         * @param vectorMasterViewA is the vector if the Avatar is person 1
         * @param vectorMasterViewB is the vector if the Avatar is person 2
         */
        fun setSkin(avatarpart: Int, vectorMasterViewA: VectorMasterView, vectorMasterViewB: VectorMasterView) {
            var path1 = vectorMasterViewA.getPathModelByName("Skin1")
            var path2 = vectorMasterViewA.getPathModelByName("Skin2")
            var path3 = vectorMasterViewA.getPathModelByName("Skin3")
            var path4 = vectorMasterViewA.getPathModelByName("Skin4")
            var path5 = vectorMasterViewB.getPathModelByName("Skin1")
            var path6 = vectorMasterViewB.getPathModelByName("Skin2")
            var path7 = vectorMasterViewB.getPathModelByName("Skin3")
            var path8 = vectorMasterViewB.getPathModelByName("Skin4")
            path1.fillColor = avatarpart
            path2.fillColor = avatarpart
            path3.fillColor = avatarpart
            path4.fillColor = avatarpart
            path5.fillColor = avatarpart
            path6.fillColor = avatarpart
            path7.fillColor = avatarpart
            path8.fillColor = avatarpart
            vectorMasterViewA.update()
            vectorMasterViewB.update()
        }

        /**
         * sets the color of the clothes of the avatar
         *
         * @param avatarpart is the color the clothes are going to be
         * @param vectorMasterViewA is the vector if the Avatar is person 1
         * @param vectorMasterViewB is the vector if the Avatar is person 2
         */
        fun setBody(avatarpart: Int, vectorMasterViewA: VectorMasterView, vectorMasterViewB: VectorMasterView) {
            var path1 = vectorMasterViewA.getPathModelByName("Body")
            var path2 = vectorMasterViewB.getPathModelByName("Body")
            path1.fillColor = avatarpart
            path2.fillColor = avatarpart
            vectorMasterViewA.update()
            vectorMasterViewB.update()
        }
    }
}
