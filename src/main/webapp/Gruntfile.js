module.exports = function(grunt) {

    grunt.initConfig({
         concat : {
            options : {
                sourceMap :true
            },
            dist : {
                src  : ['src/js/appbruxelas.js', 'src/js/services/*.js', 'src/js/directives/*.js', 'src/js/controllers/*.js'],
                dest : 'dist/appbruxelas.js'
            }
        },
        uglify : {
            dist : {
                src  : '<%= concat.dist.dest %>',
                dest : 'dist/appbruxelas.min.js'
            }
        },
         
    }); 

  // carrega plugins
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-concat');    
 
  grunt.registerTask('build', ['concat', 'uglify']);

};
