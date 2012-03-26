package friendsofmine



import org.junit.*
import grails.test.mixin.*

@TestFor(MembreController)
@Mock(Membre)
class MembreControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/membre/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.membreInstanceList.size() == 0
        assert model.membreInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.membreInstance != null
    }

    void testSave() {
        controller.save()

        assert model.membreInstance != null
        assert view == '/membre/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/membre/show/1'
        assert controller.flash.message != null
        assert Membre.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/membre/list'


        populateValidParams(params)
        def membre = new Membre(params)

        assert membre.save() != null

        params.id = membre.id

        def model = controller.show()

        assert model.membreInstance == membre
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/membre/list'


        populateValidParams(params)
        def membre = new Membre(params)

        assert membre.save() != null

        params.id = membre.id

        def model = controller.edit()

        assert model.membreInstance == membre
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/membre/list'

        response.reset()


        populateValidParams(params)
        def membre = new Membre(params)

        assert membre.save() != null

        // test invalid parameters in update
        params.id = membre.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/membre/edit"
        assert model.membreInstance != null

        membre.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/membre/show/$membre.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        membre.clearErrors()

        populateValidParams(params)
        params.id = membre.id
        params.version = -1
        controller.update()

        assert view == "/membre/edit"
        assert model.membreInstance != null
        assert model.membreInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/membre/list'

        response.reset()

        populateValidParams(params)
        def membre = new Membre(params)

        assert membre.save() != null
        assert Membre.count() == 1

        params.id = membre.id

        controller.delete()

        assert Membre.count() == 0
        assert Membre.get(membre.id) == null
        assert response.redirectedUrl == '/membre/list'
    }
}
